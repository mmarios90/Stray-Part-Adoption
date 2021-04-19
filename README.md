# Stray Part-Adoption

A Spring Boot application, providing users with the ability to select and adopt pets from a pool of strays (animal shelter),
for durations of a week. The user can sign one week for one adoption, from their given four total weeks.
In this way, the user have to repeat this adoption periodically every month ( 4 weeks = 1 month approx.).
Consequently a user can adopt up to four pets in a month, and a stray can be adopted by up to four users in a month.
Having described that, it is clear that the user and the animal must have a common week free in order to make an adoption.
Also the user have the possibility to sign for adopting the same animal for more than one time, as long as
the above restrictions are being followed.


A user is able to: Register an account,
		   Log in,
		   See the list with all animals,
		   Make an adoption by providing the animal's id and the number the desired week,
		   See the list of adoptions made by them,
		   Delete an adoption by providing the animal's id and the number of its week.

	(The users functionalities have been tested. The animals for this purpose,
	 have been installed via the database(with psql).)


An administrator (ADMIN role) can be registered through the database(psql).
An administrator has additional functionalities, concerning managing the application's
entities (add, delete). Not complete yet, they are to be enhanced.


Key concepts: Spring Boot, MVC, Spring Security, JPA, Java, PostgreSQL
