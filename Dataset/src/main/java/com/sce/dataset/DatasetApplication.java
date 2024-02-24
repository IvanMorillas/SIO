package com.sce.dataset;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@SpringBootApplication
public class DatasetApplication {

	private static final Logger log = LoggerFactory.getLogger(DatasetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatasetApplication.class);
	}

	//Hacer enums para el nombre de la plataforma y otro para title/credits para poder gestionar mejor la lectura de ficheros.
	//Mirar como poder acceder a una carpeta y leer todos los .csv y clasificarlos con el @enum.
	//Crear clases para nuevas tablas de Genero y Paises

	/*@Bean
	public CommandLineRunner readCSVPerson(IPerson repository){
		return (args) -> {
			FileReader fileCSV = null;
			CSVReader csvReader = null;
			try{
				fileCSV = new FileReader("C:\\Users\\ivanm\\OneDrive\\Escritorio\\Universidad\\4º\\SIO\\Practica\\Practica1\\Dataset\\Amazon_Prime_Credits.csv");
				CSVParser puntoYcoma = new CSVParserBuilder().withSeparator(',').build();
				csvReader = new CSVReaderBuilder(fileCSV).withCSVParser(puntoYcoma).build();
				String[] line = null;
				csvReader.readNext();
				while((line = csvReader.readNext()) != null){
					System.out.println(line[0] + "|" + line[1]
							+ "|" + line[2] + "|" + line[3] + "|" + line[4]);
					repository.save(new Persons(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4]));
				}
				log.info("Persons found with findAll():");
				log.info("-------------------------------");
				repository.findAll().forEach(Person -> {
					log.info(Person.toString());
				});
				log.info("");
			} catch (IOException e) {
				System.out.println(e);
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				try{
					fileCSV.close();
					csvReader.close();
				}catch (IOException e){
					System.out.println(e);
				}
			}
		};
	}*/

	@Bean
	public CommandLineRunner readCSVTitle(IPerson repositoryPerson, ITitle repositoryTitle, IGenres repositoryGenres,
										  ICountries repositoryCountries, ITitlesGenres repositoryTitleGenre,
										  ITitlesCountries repositoryTitleCountry, ITitlePerson repositoryTitlePerson){
		return (args) -> {
			FileReader fileCSV = null;
			CSVReader csvReader = null;
			List<String> titleIds = new ArrayList<>();
			try{
				fileCSV = new FileReader("C:\\Users\\ivanm\\OneDrive\\Escritorio\\Universidad\\4º\\SIO\\Practica\\Practica1\\Dataset\\Amazon_Prime_Titles.csv");
				CSVParser puntoYcoma = new CSVParserBuilder().withSeparator(',').build();
				csvReader = new CSVReaderBuilder(fileCSV).withCSVParser(puntoYcoma).build();
				String[] line = null;
				csvReader.readNext();
				while((line = csvReader.readNext()) != null){
					String genresString = line[7];
					List<String> genres;
					List<Integer> genreIds = new ArrayList<>();
					if(genresString.isEmpty()){
						genres = null;
					}else if (genresString.length() < 4){
						genres = new ArrayList<>();
					}else{
						String[] genreArray = genresString.substring(1, genresString.length() - 1).split("(?<!\\\\),");
						genres = Arrays.stream(genreArray)
								.map(genre -> genre.replace("'", ""))
								.map(genre -> genre.replace(" ", ""))
								.collect(Collectors.toList());}
					if(genres != null){
						for(String genre : genres){
							Genres genreObject = (Genres) repositoryGenres.findByGenreName(genre);
							if(genreObject == null){
								genreObject = new Genres(genre);
								repositoryGenres.save(genreObject);
							}
							genreIds.add(genreObject.getGenreId());
						}
					}

					String countriesString = line[8];
					List<String> countries;
					List<Integer> countryIds = new ArrayList<>();
					if(countriesString.isEmpty()){
						countries = null;
					}else if (countriesString.length() < 4){
						countries = new ArrayList<>();
					}else{
						String[] countryArray = countriesString.substring(1, countriesString.length() - 1).split("(?<!\\\\),");
						countries = Arrays.stream(countryArray)
								.map(country -> country.replace("'", ""))
								.map(country -> country.replace(" ", ""))
								.collect(Collectors.toList());}
					if(countries != null){
						for(String country : countries){
							Countries CountryObject = (Countries) repositoryCountries.findByCountryName(country);
							if(CountryObject == null){
								CountryObject = new Countries(country);
								repositoryCountries.save(CountryObject);
							}
							countryIds.add(CountryObject.getCountryId());
						}
					}
					titleIds.add(line[0]);

					/*System.out.println(line[0] + "|" + line[1] + "|" + line[2] + "|" + line[3] + "|" + line[4] + "|" + line[5]
							+ "|" + line[6] + "|" + genres + "|" + countries
							+ "|" + line[9] + "|" + line[10] + "|" + line[11]
							+ "|" + line[12] + "|" + line[13] + "|" + line[14]);*/
					String seasons = line[9];
					String imdb_score = line[11];
					String imdb_votes = line[12];
					String tmdb_popularity = line[13];
					String tmdb_score = line[14];
					if (seasons.isEmpty()){
						seasons = "0.0";
					}
					if (imdb_score.isEmpty()){
						imdb_score = "0.0";
					}
					if (imdb_votes.isEmpty()){
						imdb_votes = "0.0";
					}
					if (tmdb_popularity.isEmpty()){
						tmdb_popularity = "0.0";
					}
					if (tmdb_score.isEmpty()){
						tmdb_score = "0.0";
					}
					repositoryTitle.save(new Titles(line[0], line[1], line[2], line[3], Integer.parseInt(line[4]),
							line[5], Integer.parseInt(line[6]), /*genres, countries,*/ Double.parseDouble(seasons),
							line[10], Double.parseDouble(imdb_score), Double.parseDouble(imdb_votes),
							Double.parseDouble(tmdb_popularity), Double.parseDouble(tmdb_score)));

					for (Integer genreId : genreIds) {
						TitlesGenres titleGenre = new TitlesGenres(line[0], genreId);
						repositoryTitleGenre.save(titleGenre);
					}
					for (Integer countryId : countryIds) {
						TitlesCountries titleCountry = new TitlesCountries(line[0], countryId);
						repositoryTitleCountry.save(titleCountry);
					}
				}
			} catch (IOException e) {
				System.out.println(e);
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				try{
					fileCSV.close();
					csvReader.close();
				}catch (IOException e){
					System.out.println(e);
				}
			}
			try{
				fileCSV = new FileReader("C:\\Users\\ivanm\\OneDrive\\Escritorio\\Universidad\\4º\\SIO\\Practica\\Practica1\\Dataset\\Amazon_Prime_Credits.csv");
				CSVParser puntoYcoma = new CSVParserBuilder().withSeparator(',').build();
				csvReader = new CSVReaderBuilder(fileCSV).withCSVParser(puntoYcoma).build();
				String[] line = null;
				csvReader.readNext();
				while((line = csvReader.readNext()) != null){
					System.out.println(line[0] + "|" + line[1]
							+ "|" + line[2] + "|" + line[3] + "|" + line[4]);
					repositoryPerson.save(new Persons(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4]));
					for (String title : titleIds) {
						if(title.equals(line[1])){
							TitlePerson titlePerson = new TitlePerson(Integer.parseInt(line[0]), title);
							repositoryTitlePerson.save(titlePerson);
						}
					}
				}
			} catch (IOException e) {
				System.out.println(e);
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				try{
					fileCSV.close();
					csvReader.close();
				}catch (IOException e){
					System.out.println(e);
				}
			}
		};
	}

	/*@Bean
	public CommandLineRunner demoPerson(IPerson repository) {
		return (args) -> {
			repository.save(new Person(59401, "ts20945", "Joe Besser", "Joe", "ACTOR"));
			log.info("Persons found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(Person -> {
				log.info(Person.toString());
			});
			log.info("");
		};
	}*/

	/*@Bean
	public CommandLineRunner demoTitle(ITitle repository) {
		return (args) -> {
			repository.save(new Title("ts20945","The Three Stooges","SHOW",
					"The Three Stooges were an American vaudeville .",1934,
					"TV-PG",19, Arrays.asList("comedy", "family", "animation", "action", "fantasy", "horror"),
					Arrays.asList("US","ESP"),26.0,"tt0850645",8.6,
					1092.0,15.424,7.6));
			log.info("Titles found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(Title -> {
				log.info(Title.toString());
			});
			log.info("");
		};
	}*/
}
