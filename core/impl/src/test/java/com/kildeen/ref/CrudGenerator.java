package com.kildeen.ref;

import com.kildeen.ref.application.module.fact.FactRepository;
import com.kildeen.ref.system.Pages;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * <p>File created: 2014-04-23 21:59</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class CrudGenerator {

    public void generate() throws Exception {
        System.out.println(Pages.Admin.Group.GroupSetup.class.getCanonicalName());

        Class<FactRepository> clazz = FactRepository.class;
        for (Method s : clazz.getDeclaredMethods()) {
            File f = findFile(clazz.getSimpleName(), "C:\\projects\\ref\\core\\impl\\src\\main\\java\\com\\kildeen\\ref\\application");
            for (int i =0; i< s.getParameterTypes().length; i++) {
                Scanner sc = new Scanner(f);
                    while (sc.hasNext()) {
                        String line = sc.nextLine();
                        if (line.contains(s.getName())) {
                           String cut = line.substring(line.indexOf("("));
                            cut = cut.replace(";","");
                            cut = cut.replace("@QueryParam","");
                            cut = cut.replaceAll("\\\".*\\\"", "");
                            cut = cut.replace("\"","");
                            cut = cut.replace("(", "");
                            cut = cut.replace(")","");
                            cut = cut.replace("  "," ");
                            cut = cut.trim();

                            System.out.println("public " + s.getName()+String.format("(%s) {", cut));
                            System.out.println(StringUtils.uncapitalize(clazz.getSimpleName()));
                            break;
                        }
                    }
            }
        }


    }


    public static File findFile(String filename, String rootDir) {
        File root = new File(rootDir);
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root,null, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                if (file.getName().equals(filename+".java")) return file;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("not found");
    }
}
