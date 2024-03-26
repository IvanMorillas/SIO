package com.sce.dataset;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class DatasetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasetApplication.class);
	}
	@Bean
	public CommandLineRunner readDirectory(IStreamings repositoryStreamings, ITitlesStreamings repositoryTitlesStreamings,
										   IPerson repositoryPerson, ITitle repositoryTitle, IGenres repositoryGenres,
										   ICountries repositoryCountries, ITitlesGenres repositoryTitleGenre,
										   ITitlesCountries repositoryTitleCountry, ITitlePerson repositoryTitlePerson,
										   IRoles repositoryRoles, ITitlesDuplicated repositoryTitlesDuplicated) {
		return (args) -> {
			System.out.println("Reading files...");
			FileReader fileCSV = null;
			CSVReader csvReader = null;
			List<String> titleIds = new ArrayList<>();
			List<String> titleNames = new ArrayList<>();
			List<Integer> streamingIds = new ArrayList<>();
			String nameFile;
			File directory = new File("C:\\Users\\Usuario\\Documents\\SIO\\Dataset\\files");
			System.out.println("Reading files from " + directory.getAbsolutePath() + " directory...");
			if(!directory.exists()){
				System.out.println("Directory not found!");
			}
			File[] files = directory.listFiles();
			for(File file : files) {
				System.out.println(files.length + " files found.");
				System.out.println("Reading " + file.getName() + " file...");
				String completeName = file.getName();
				int index = completeName.lastIndexOf("_");
				nameFile = completeName.substring(0, index);
				System.out.println(repositoryStreamings.existsByStreamingName(nameFile));
				titleNames.add(nameFile);
                if (repositoryStreamings.findByStreamingName(nameFile) == null) {
					System.out.println("Saving " + nameFile + " file...");
					titleNames.add(nameFile);
					repositoryStreamings.save(new Streamings(nameFile));
					streamingIds.add(repositoryStreamings.findByStreamingName(nameFile).getStreamingId());
				}
				System.out.println("All files have been readed and saved.");
			}
			for(String name : titleNames) {
				System.out.println("Reading " + name + " files...");
				try {
					fileCSV = new FileReader("C:\\Users\\Usuario\\Documents\\SIO\\Dataset\\files\\" + name + "_Titles.csv");
					Long total = Files.lines(Paths.get("C:\\Users\\Usuario\\Documents\\SIO\\Dataset\\files\\" + name + "_Titles.csv")).count();
					System.out.println(name + "_Titles.csv reading...");
					String[] line = null;
					int progress = 0;
					CSVParser puntoYcoma = new CSVParserBuilder().withSeparator(',').build();
					csvReader = new CSVReaderBuilder(fileCSV).withCSVParser(puntoYcoma).build();
					csvReader.readNext();
					while ((line = csvReader.readNext()) != null) {
						String genresString = line[7];
						List<String> genres;
						List<Integer> genreIds = new ArrayList<>();
						if (genresString.isEmpty()) {
							genres = null;
						} else if (genresString.length() < 4) {
							genres = new ArrayList<>();
						} else {
							String[] genreArray = genresString.substring(1, genresString.length() - 1).split("(?<!\\\\),");
							genres = Arrays.stream(genreArray)
									.map(genre -> genre.replace("'", ""))
									.map(genre -> genre.replace(" ", ""))
									.collect(Collectors.toList());
						}
						if (genres != null) {
							for (String genre : genres) {
								Genres genreObject = (Genres) repositoryGenres.findByGenreName(genre);
								if (genreObject == null) {
									genreObject = new Genres(genre);
									repositoryGenres.save(genreObject);
								}
								genreIds.add(genreObject.getGenreId());
							}
						}
						String countriesString = line[8];
						List<String> countries;
						List<Integer> countryIds = new ArrayList<>();
						if (countriesString.isEmpty()) {
							countries = null;
						} else if (countriesString.length() < 4) {
							countries = new ArrayList<>();
						} else {
							String[] countryArray = countriesString.substring(1, countriesString.length() - 1).split("(?<!\\\\),");
							countries = Arrays.stream(countryArray)
									.map(country -> country.replace("'", ""))
									.map(country -> country.replace(" ", ""))
									.collect(Collectors.toList());
						}
						if (countries != null) {
							for (String country : countries) {
								Countries CountryObject = (Countries) repositoryCountries.findByCountryName(country);
								if (CountryObject == null) {
									CountryObject = new Countries(country);
									repositoryCountries.save(CountryObject);
								}
								countryIds.add(CountryObject.getCountryId());
							}
						}
						titleIds.add(line[0]);
						String seasons = line[9];
						String imdb_score = line[11];
						String imdb_votes = line[12];
						String tmdb_popularity = line[13];
						String tmdb_score = line[14];
						if (seasons.isEmpty()) {
							seasons = "0.0";
						}
						if (imdb_score.isEmpty()) {
							imdb_score = "0.0";
						}
						if (imdb_votes.isEmpty()) {
							imdb_votes = "0.0";
						}
						if (tmdb_popularity.isEmpty()) {
							tmdb_popularity = "0.0";
						}
						if (tmdb_score.isEmpty()) {
							tmdb_score = "0.0";
						}
						if (!repositoryTitle.existsById(line[0])) {
							repositoryTitle.save(new Titles(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]),
									line[5], Integer.parseInt(line[6]), Double.parseDouble(seasons),
									line[10], Double.parseDouble(imdb_score), Double.parseDouble(imdb_votes),
									Double.parseDouble(tmdb_popularity), Double.parseDouble(tmdb_score)));
						}else{
							Titles originalTitle = repositoryTitle.findById(line[0]).get();
							boolean areEquals = compareData(line, originalTitle);
							if(!areEquals){
								repositoryTitlesDuplicated.save(new TitlesDuplicated(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]),
										line[5], Integer.parseInt(line[6]), Double.parseDouble(seasons),
										line[10], Double.parseDouble(imdb_score), Double.parseDouble(imdb_votes),
										Double.parseDouble(tmdb_popularity), Double.parseDouble(tmdb_score)));
							}
						}
						for (Integer genreId : genreIds) {
							if (!repositoryTitleGenre.existsByGenreIdAndTitleId(genreId, line[0])) {
								TitlesGenres titleGenre = new TitlesGenres(line[0], genreId);
								repositoryTitleGenre.save(titleGenre);
							}
						}
						for (Integer countryId : countryIds) {
							if (!repositoryTitleCountry.existsByCountryIdAndTitleId(countryId, line[0])) {
								TitlesCountries titleCountry = new TitlesCountries(line[0], countryId);
								repositoryTitleCountry.save(titleCountry);
							}
						}
						for (Integer streamingId : streamingIds) {
							if(streamingId == repositoryStreamings.findByStreamingName(name).getStreamingId()){
								if (!repositoryTitlesStreamings.existsByStreamingIdAndTitleId(streamingId, line[0])) {
									TitlesStreamings streamingTitle = new TitlesStreamings(line[0], streamingId);
									repositoryTitlesStreamings.save(streamingTitle);
								}
							}
						}
						progress++;
						double percentage = (double) progress / total * 100;
						System.out.print(String.format("%3.2f%%", percentage));
						System.out.print("\r");
					}
				} catch (IOException e) {
					System.out.println(e);
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					try {
						fileCSV.close();
						csvReader.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				System.out.println("All titles have been readed and saved.");
				try {
					fileCSV = new FileReader("C:\\Users\\Usuario\\Documents\\SIO\\Dataset\\files\\" + name + "_Credits.csv");
					Long total = Files.lines(Paths.get("C:\\Users\\Usuario\\Documents\\SIO\\Dataset\\files\\" + name + "_Credits.csv")).count();
					System.out.println(name + "_Credits.csv reading...");
					int progress = 0;
					CSVParser puntoYcoma = new CSVParserBuilder().withSeparator(',').build();
					csvReader = new CSVReaderBuilder(fileCSV).withCSVParser(puntoYcoma).build();
					String[] line = null;
					csvReader.readNext();
					while ((line = csvReader.readNext()) != null) {
						repositoryPerson.save(new Persons(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4]));
						String roleString = line[4];
						List<String> roles = new ArrayList<>();
						List<Integer> rolesIds = new ArrayList<>();
						if (roleString.isEmpty()) {
							roles = null;
						} else {
							roles.add(roleString);
						}
						if (roles != null) {
							for (String role : roles) {
								Roles roleObject = (Roles) repositoryRoles.findByRoleName(role);
								if (roleObject == null) {
									roleObject = new Roles(role);
									repositoryRoles.save(roleObject);
								}
								rolesIds.add(roleObject.getRoleId());
							}
						}
						for (String title : titleIds) {
							if (line[1].equals(title)) {
								for (Integer roleId : rolesIds) {
									if (!repositoryTitlePerson.existsByPersonIdAndTitleIdAndRoleId(Integer.parseInt(line[0]), title, roleId)) {
										TitlePerson titlePerson = new TitlePerson(Integer.parseInt(line[0]), title, roleId);
										repositoryTitlePerson.save(titlePerson);
									}
								}
							}
						}
						progress++;
						double percentage = (double) progress / total * 100;
						System.out.print(String.format("%3.2f%%", percentage));
						System.out.print("\r");
					}
				} catch (IOException e) {
					System.out.println(e);
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					try {
						fileCSV.close();
						csvReader.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				System.out.println("All persons have been readed and saved.");
			}
		};
	}
	private boolean compareData(String[] line, Titles originalTitle) {
		return (isEmptyOrEqual(line[1], originalTitle.getTitle()) &&
				isEmptyOrEqual(line[2], originalTitle.getTitleType()) &&
				isEmptyOrEqual(line[3], originalTitle.getTitleDescription()) &&
				(isEmpty(line[4]) || Integer.parseInt(line[4]) == originalTitle.getTitleReleaseYear()) &&
				isEmptyOrEqual(line[5], originalTitle.getTitleAgeCertification()) &&
				(isEmpty(line[6]) || Integer.parseInt(line[6]) == originalTitle.getTitleRuntime()) &&
				(isEmpty(line[9]) || Double.parseDouble(line[9]) == originalTitle.getTitleSeasons()) &&
				isEmptyOrEqual(line[10], originalTitle.getTitleImdbId()) &&
				(isEmpty(line[11]) || Double.parseDouble(line[11]) == originalTitle.getTitleImdbScore()) &&
				(isEmpty(line[12]) || Double.parseDouble(line[12]) == originalTitle.getTitleImdbVotes()) &&
				(isEmpty(line[13]) || Double.parseDouble(line[13]) == originalTitle.getTitleTmdbPopularity()) &&
				(isEmpty(line[14]) || Double.parseDouble(line[14]) == originalTitle.getTitleTmdbScore()));
	}
	private boolean isEmptyOrEqual(String value1, String value2) {
		return (value1 == null || value1.isEmpty()) ? value2 == null || value2.isEmpty() : value1.equals(value2);
	}

	private boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

}
