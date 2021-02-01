package com.grouptransportes.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;


/**
 * @author Leandro Marques
 */
public final class TilesDefinitionsConfig implements DefinitionsFactory {
 
	private static final Map<String, Definition> tilesDefinitions = new HashMap<String,Definition>();
	private static final Attribute MASTERPAGE = new Attribute("/WEB-INF/views/template/masterPage.jsp");
	
	@Override
	public Definition getDefinition(String name, Request tilesContext) {
		 return tilesDefinitions.get(name);
	}

	private static void masterPage(String name, String title, String body) {
		Map<String, Attribute> attributes = new HashMap<String,Attribute>();
		attributes.put("title", new Attribute(title));
		attributes.put("menu", new Attribute("/WEB-INF/views/template/menu.jsp"));
		attributes.put("body", new Attribute(body));
		tilesDefinitions.put(name, new Definition(name, MASTERPAGE, attributes));
	}

	public static void addDefinitions() {
		masterPage("home", "Veículos", "/WEB-INF/views/index.jsp");
		masterPage("cadastroVeiculos", "Veículos", "/WEB-INF/views/veiculo/cadastroVeiculos.jsp");
		masterPage("simuladorFrete", "Simulador", "/WEB-INF/views/simulador/simuladorFrete.jsp");
	}

}