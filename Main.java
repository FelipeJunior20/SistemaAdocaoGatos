package ME2unidade;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main extends JFrame {

    public static void main(String[] args) {
        Main formeHome = new Main();
        formeHome.setVisible(true);
    }

    private JButton btCadastroAdotantes;
    private JButton btCadastroGatos;
    private JButton btConsultaAdotantes;
    private JButton btConsultaGatos;
    private JButton btAdoçãoGatos;
    private JButton btRelatoriodeProvisoes;
    private ArrayList<Adotantes> listaAdotantes;
    private ArrayList<Gatos> listaGatos;
    private ArrayList<Gatos> listaGatosAdotados;
    private ArrayList<Double> listaRaçãoNormal;
    private ArrayList<Double> listaRaçãoPremium;
    
    public Main() {

        this.setTitle("Sistema");
        setBounds(0,0, 700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    
        btCadastroAdotantes = new JButton();
        btCadastroAdotantes.setText("Cadastrar Adotante");
        btCadastroAdotantes.setBounds(10,10,150,30);
        this.add(btCadastroAdotantes);

        btConsultaAdotantes = new JButton();
        btConsultaAdotantes.setText("Consulta de todos os Adotantes Cadastrados");
        btConsultaAdotantes.setBounds(170,10,150,30);
        this.add(btConsultaAdotantes);

        listaAdotantes = new ArrayList<Adotantes>();
        listaGatos = new ArrayList<Gatos>();
        listaGatosAdotados = new ArrayList<Gatos>();
        listaRaçãoNormal = new ArrayList<Double>();
        listaRaçãoPremium = new ArrayList<Double>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


        btCadastroAdotantes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Adotantes adotantes = new Adotantes();
                adotantes.setCpf(JOptionPane.showInputDialog("Cpf: "));
                adotantes.setNomecompleto(JOptionPane.showInputDialog("Nome Completo:"));
                adotantes.setEndereço(JOptionPane.showInputDialog("Endereço: "));
                adotantes.setTelefone(JOptionPane.showInputDialog("Telefone: "));
                listaAdotantes.add(adotantes);
                JOptionPane.showMessageDialog(null, "Cadastro do Adotante feito com sucesso!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                
            }
    
        });

        btConsultaAdotantes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Adotantes adotantes : listaAdotantes) {
                    JOptionPane.showMessageDialog(null, "Nome Completo:" + adotantes.getNomecompleto() + "\n Cpf: " + adotantes.getCpf() + "\n Endereço: " + adotantes.getEndereço() + "\n Telefone: " + adotantes.getTelefone(), "Adotantes", JOptionPane.INFORMATION_MESSAGE );
                    
            }

        };
    

        });
        
        btCadastroGatos = new JButton();
        btCadastroGatos.setText("Cadastro de Gatos");
        btCadastroGatos.setBounds(330, 10, 150, 30);
        this.add(btCadastroGatos);

        btConsultaGatos = new JButton();
        btConsultaGatos.setText("Consulta de Gatos");
        btConsultaGatos.setBounds(490,10, 150, 30);
        this.add(btConsultaGatos);



        btCadastroGatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Gatos gatos = new Gatos();
                    gatos.setCod(JOptionPane.showInputDialog("Codigo Único do Gato"));
                    gatos.setNome(JOptionPane.showInputDialog("Nome:"));
                    gatos.setRaça(JOptionPane.showInputDialog("Raça: "));
                    gatos.setApelido(JOptionPane.showInputDialog("Apelido: "));
                    gatos.setSexo(JOptionPane.showInputDialog("Sexo [Femea/Macho]: "));
                    gatos.setDatadeEntrada(new Date(System.currentTimeMillis()));
                    gatos.setIdadeAproximada(Integer.parseInt(JOptionPane.showInputDialog("Idade aproximada do gato: ")));
                    gatos.setNomedaRação(JOptionPane.showInputDialog("Nome da Ração [Normal/Premium]:"));
                    gatos.setQuantidadedaRação(Double.parseDouble(JOptionPane.showInputDialog("Quantidade da Ração [Em gramas]: ")));
                    gatos.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso:")));
                    listaGatos.add(gatos);
                    JOptionPane.showMessageDialog(null, "Cadastro do Gato realizado com sucesso!", "Resultado",JOptionPane.INFORMATION_MESSAGE); 
                    
                    if (gatos.getNomedaRação().equalsIgnoreCase("Normal")) {
                        listaRaçãoNormal.add(gatos.getQuantidadedaRação());
                    }
                    if (gatos.getNomedaRação().equalsIgnoreCase("Premium")) {
                        listaRaçãoPremium.add(gatos.getQuantidadedaRação());
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
				}
                
                
            }

        });

        btConsultaGatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for (Gatos g : listaGatos) {
                    JOptionPane.showMessageDialog(null, "Cod :" + g.getCod() + "\n Nome:"  + g.getNome() + "\n Idade Aproximada: " + g.getIdadeAproximada() +"\n Raça: " + g.getRaça() + "\n Apelido: "+ g.getApelido()+ "\n Sexo: " + g.getSexo()+ "\n Nome da Ração: " + g.getNomedaRação()+ "\n Quantidade de Ração: " + g.getQuantidadedaRação() +"\n Peso: " + g.getPeso(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                         
                }
                
                for (Gatos a : listaGatosAdotados) {
                    JOptionPane.showMessageDialog(null, "Cod :" + a.getCod() + "\n Nome:"  + a.getNome() + "\n Idade Aproximada: " + a.getIdadeAproximada() + "\n Raça: " + a.getRaça() + "\n Apelido: "+ a.getApelido()+ "\n Sexo: " + a.getSexo()+ "\n Nome da Ração: " + a.getNomedaRação()+ "\n Quantidade de Ração: " + a.getQuantidadedaRação() + "\n Peso: " + a.getPeso()+ "\n Cpf do Adotante: " + a.getCpfAdotante() + "\n Data de entrada "+ a.getdatadeEntrada() + "\n Data de saída: " + a.getDatadeSaida(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                

            }
            }
    });

        btAdoçãoGatos = new JButton();
        btAdoçãoGatos.setText("Adoção de Gatos");
        btAdoçãoGatos.setBounds(10, 50, 150, 30);
        this.add(btAdoçãoGatos);

        btAdoçãoGatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String Cpf = JOptionPane.showInputDialog("Cpf do Adotante: ");
                    String Cod = JOptionPane.showInputDialog("Codigo Único do Gato: ");
                    int indiceA = -1;
                    int indiceG = -1;
                    Gatos gatos = new Gatos();
                
                    for (int i = 0; i < listaAdotantes.size(); i++) {
                        if (Cpf.equalsIgnoreCase(listaAdotantes.get(i).getCpf())) {
                            indiceA = i;
                        }
                    }

                    for (int g = 0; g < listaGatos.size(); g++) {
                        if (Cod.equalsIgnoreCase(listaGatos.get(g).getCod()));
                            indiceG = g;
                            gatos = listaGatos.get(g);
                    }
                    

                    if (indiceA == -1) {
                         JOptionPane.showMessageDialog(null, "Cpf do Adotante citado não está Cadastrado!", "Alerta",JOptionPane.WARNING_MESSAGE);
                    }

                    if (indiceG == -1) {
                        JOptionPane.showMessageDialog(null, "Codigo único do gato citado não está Cadastrado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                    
                    else {
                        gatos.setDatadeSaida(format.parse(JOptionPane.showInputDialog("Data de Saída: ")));
                        gatos.setCpfAdotante(JOptionPane.showInputDialog("Cpf do Adotante: "));
                        listaGatos.remove(indiceG);
                        listaGatosAdotados.add(gatos);
                    }

                    if (listaRaçãoNormal.size() > 0) {
                        listaRaçãoNormal.remove(indiceG);
                    }

                    if (listaRaçãoPremium.size() > 0) {
                        listaRaçãoPremium.remove(indiceG);
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
				}
                
            }
        });

        btRelatoriodeProvisoes = new JButton();
        btRelatoriodeProvisoes.setText("Relatorio de Provisões");
        btRelatoriodeProvisoes.setBounds(170, 50, 150, 30);
        this.add(btRelatoriodeProvisoes);

        btRelatoriodeProvisoes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double somadaRaçãoNormal =  0;
                double resultadoRaçãoNormal = 0;
                for (double in : listaRaçãoNormal) {
                    somadaRaçãoNormal += in;
                    resultadoRaçãoNormal = somadaRaçãoNormal * 7;
                    
                }
                if (listaRaçãoNormal.size() > 0) {
                    JOptionPane.showMessageDialog(null, "Soma da Ração Normal gasta na semana: "+ resultadoRaçãoNormal, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
                double somadaRaçãoPremium = 0;
                double resultadoRaçãoPremium = 0;
                for (Double ip : listaRaçãoPremium) {
                    somadaRaçãoPremium += ip;
                    resultadoRaçãoPremium += somadaRaçãoPremium * 7;

                }
                if (listaRaçãoPremium.size() > 0) {
                    JOptionPane.showMessageDialog(null, "Soma da Ração Premium gasta na semana: "+ resultadoRaçãoPremium, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        }); 



}
}
