package com.pro.fts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })

@SpringBootApplication
public class TicketingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingServiceApplication.class, args);
		System.out.println("\n" +
				"┏┳┓• ┓    •      ┏┓┏┓┏┓                                       \n" +
				" ┃ ┓┏┃┏┏┓╋┓┏┓┏┓  ┣┫┃┃┃┃                                       \n" +
				" ┻ ┗┗┛┗┗ ┗┗┛┗┗┫  ┛┗┣┛┣┛                                       \n" +
				"┳┓        ┳┳┓ ┛┓ •                                            \n" +
				"┣┫┓┏  ━━  ┃┃┃┏┓┣┓┓╋                                           \n" +
				"┻┛┗┫      ┛ ┗┗┛┛┗┗┗                                           \n" +
				"   ┛                                                          \n" +
				"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
				"                                            ┳  • •      ┓     \n" +
				"                                            ┃┏┓┓╋┓┏┓╋┏┓┏┫     \n" +
				"                                            ┻┛┗┗┗┗┗┻┗┗ ┗┻     \n" +
				"                                                              \n");
	}

}
