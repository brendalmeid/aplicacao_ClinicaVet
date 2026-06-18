// util/Relatorios.java
package util;

import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorios {

    /**
     * Gera e exibe um relatório .jasper (já compilado) com conexão e parâmetros.
     *
     * @param nomeRelatorio nome do arquivo sem extensão, ex: "Lista_Alunos"
     * @param parametros    mapa de parâmetros (null se não houver)
     */
    public static void gerarRelatorio(String nomeRelatorio, Map<String, Object> parametros) {
        Conexao c = new Conexao();
        c.conectar();

        try {
            String caminhoRelatorio = "/relatorios/" + nomeRelatorio + ".jasper";
            InputStream relStream = Relatorios.class.getResourceAsStream(caminhoRelatorio);

            if (relStream == null) {
                throw new JRException("Relatório não encontrado em: " + caminhoRelatorio);
            }

            if (parametros == null) {
                parametros = new HashMap<>();
            }

            JasperPrint print = JasperFillManager.fillReport(
                relStream,
                parametros,
                c.conector
            );

            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException e) {
            System.err.println("Erro no JasperReports: " + e.getMessage());
            throw new RuntimeException("Impossível abrir o relatório!", e);

        } finally {
            c.desconectar();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Gerando relatório 'Lista_Alunos'...");
            gerarRelatorio("Lista_Alunos", null);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro geral: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
