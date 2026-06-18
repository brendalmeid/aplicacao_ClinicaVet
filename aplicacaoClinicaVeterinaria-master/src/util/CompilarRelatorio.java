package util;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import java.io.File;

public class CompilarRelatorio {

    public static void main(String[] args) {
        // 1. Pega a raiz do projeto onde você executou o programa
        String projectRoot = System.getProperty("user.dir");
        // 2. Monta o caminho relativo até a pasta dos .jrxml
        File relDir = new File(projectRoot, "src/relatorios");

        // 3. Filtra apenas os arquivos que terminam em .jrxml
        File[] jrxmlFiles = relDir.listFiles((dir, name) ->
            name.toLowerCase().endsWith(".jrxml")
        );

        if (jrxmlFiles == null) {
            System.err.println("Pasta não encontrada ou sem permissão de acesso: " 
                + relDir.getAbsolutePath());
            return;
        }

        System.out.println("Iniciando compilação de " 
            + jrxmlFiles.length + " relatórios...");
        System.out.println("Pasta de origem: " 
            + relDir.getAbsolutePath());
        System.out.println("--------------------------------------------------");

        // 4. Para cada .jrxml, gera o .jasper correspondente
        for (File jrxml : jrxmlFiles) {
            // extrai o nome sem extensão
            String nomeSemExt = jrxml.getName()
                .substring(0, jrxml.getName().lastIndexOf('.'));
            File jasperFile = new File(relDir, nomeSemExt + ".jasper");

            try {
                System.out.print("Compilando '" 
                    + jrxml.getName() + "'... ");
                JasperCompileManager.compileReportToFile(
                    jrxml.getAbsolutePath(),
                    jasperFile.getAbsolutePath()
                );
                System.out.println("[SUCESSO!]");
            } catch (JRException e) {
                System.out.println("[FALHA!]");
                System.err.println("    >> Erro ao compilar '" 
                    + jrxml.getName() + "': " 
                    + e.getMessage());
                // Para debug completo, descomente:
                // e.printStackTrace();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Processo de compilação finalizado.");
    }
}
