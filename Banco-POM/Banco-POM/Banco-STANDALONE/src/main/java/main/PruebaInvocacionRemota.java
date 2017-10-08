package main;

import javax.naming.NamingException;

import Interfaces.PersonaRemote;
import entidades.Persona;
import util.ServiceLocator;

public class PruebaInvocacionRemota {

	public static void main(String[] args) {

		try {
			PersonaRemote remote = (PersonaRemote) 
					ServiceLocator.buscarEJB("PersonaEJB", "Interfaces.PersonaRemote");

			Persona persona = new Persona();
			persona.setCedula("115678940");
			persona.setNombre("Romain Bardet");

			remote.crearPersona(persona);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
