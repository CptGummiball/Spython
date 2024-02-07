package org.cptgum.spython.GetData;

import org.w3c.dom.NodeList;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Files {

    // Method to query data from a file
    public static Object queryData(String filePath, FileType fileType) {
        switch (fileType) {
            case YAML:
                return queryYAML(filePath);
            case JSON:
                return queryJSON(filePath);
            case XML:
                return queryXML(filePath);
            case TXT:
                return queryTXT(filePath);
            default:
                return null;
        }
    }

    // Method to write data to a file
    public static void writeData(String filePath, FileType fileType, Object data) {
        switch (fileType) {
            case YAML:
                writeYAML(filePath, (Map<String, Object>) data);
                break;
            case JSON:
                writeJSON(filePath, (JSONObject) data);
                break;
            case XML:
                writeXML(filePath, (Map<String, String>) data);
                break;
            case TXT:
                writeTXT(filePath, (String) data);
                break;
        }
    }

    // Enumeration for file types
    public enum FileType {
        YAML,
        JSON,
        XML,
        TXT
    }

    // Method to query data from YAML file
    public static Map<String, Object> queryYAML(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            Yaml yaml = new Yaml();
            return yaml.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write data to YAML file
    public static void writeYAML(String filePath, Map<String, Object> data) {
        try (Writer writer = new FileWriter(filePath)) {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yaml = new Yaml(options);
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to query data from JSON file
    public static JSONObject queryJSON(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            return (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write data to JSON file
    public static void writeJSON(String filePath, JSONObject data) {
        try (Writer writer = new FileWriter(filePath)) {
            writer.write(data.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to query data from XML file
    public static Map<String, String> queryXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            Map<String, String> data = new HashMap<>();

            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    data.put(element.getTagName(), element.getTextContent());
                }
            }

            return data;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write data to XML file
    public static void writeXML(String filePath, Map<String, String> data) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("root");
            document.appendChild(root);

            for (Map.Entry<String, String> entry : data.entrySet()) {
                Element element = document.createElement(entry.getKey());
                element.appendChild(document.createTextNode(entry.getValue()));
                root.appendChild(element);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    // Method to query data from TXT file
    public static String queryTXT(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write data to TXT file
    public static void writeTXT(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
