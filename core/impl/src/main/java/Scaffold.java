
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * <p>File created: 2014-05-04 18:23</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class Scaffold {

//    public static String SERVICE = "package com.kildeen.ref.application.module.#;\n" +
//            "\n" +
//            "import java.util.List;\n" +
//            "\n" +
//            "/**\n" +
//            " *\n" +
//            " */\n" +
//            "public interface %Service {\n" +
//            "    public List<%> fetch%();\n" +
//            "    public % fetch%(long id);\n" +
//            "\n" +
//            "}";
//
//    public static void main(String[] args) {
//
//        Class<?> entity;
//
//        String servicePackage;
//
//        boolean useDTO;
//
//        boolean generateJSF;
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("use this path? " + System.getProperty("user.dir"));
//
//        boolean useDir = getBoolean(sc);
//
//        String path = System.getProperty("user.dir");
//        if (useDir == false) {
//            System.out.println("Specify path:");
//            path = sc.nextLine();
//        }
//
//        File f = findFile("GroupService", path);
//
//
//        System.out.println("For entity:");
//        String entityName = sc.nextLine();
//        String temp = "com.kildeen.ref.domain." + entityName;
//
//
//        try {
//            entity = Class.forName(temp);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("derive package from entity name?");
//
//        boolean derivePackage = getBoolean(sc);
//
//        String packageName = entityName.toLowerCase();
//        if (derivePackage == false) {
//            System.out.println("package: (will still be under module)");
//            packageName = sc.nextLine();
//        }
//
//        System.out.println("useDTO:");
//
//        useDTO = getBoolean(sc);
//
//        System.out.println("Generate JSF:");
//
//        generateJSF = getBoolean(sc);
//                                      String servicePath = f.getAbsolutePath();
//
//        servicePath = servicePath.replace("authorization", packageName);
//        String newDirPath = servicePath.replace("GroupService.java", "");
//        servicePath = servicePath.replace("Group", entityName);
//        File newService = new File(servicePath);
//        try {
//
//            File dir = new File(newDirPath);
//            dir.mkdirs();
//            newService.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(newService);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            String content = SERVICE.replace("#", packageName);
//            content = content.replace("%", entityName);
//            fileWriter.write(content);
//            fileWriter.flush();
//            fileWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static boolean getBoolean(final Scanner sc) {
//        String temp = sc.nextLine();
//        return temp.toLowerCase().equals("y") || temp.toLowerCase().equals("true");
//    }
//
//
//    public static File findFile(String filename, String rootDir) {
//        File root = new File(rootDir);
//        try {
//            boolean recursive = true;
//
//            Collection files = FileUtils.listFiles(root, null, recursive);
//
//            for (Iterator iterator = files.iterator(); iterator.hasNext(); ) {
//                File file = (File) iterator.next();
//                if (file.getName().equals(filename + ".java")) return file;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        throw new RuntimeException("not found");
//    }



}
