package view;

import controller.DonosController;
import controller.PetsController;
import model.DonosModel;
import model.PetsModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gamer (Re-re-adaptado por Gemini, com lógica de ID de Dono)
 */
public class PetsView extends javax.swing.JInternalFrame {

    private ArrayList<DonosModel> listaDonos; // Lista de Donos para o JComboBox
    private int linha = -1; // Linha selecionada na tabela

    /**
     * Creates new form PetsView
     */
    public PetsView() {
        initComponents();
        preencherTabela(); // Preenche a tabela ao iniciar
        inicializar();    // Inicializa o estado dos campos e botões
        preencherComboDonos(); // Preenche o ComboBox de donos
        preencherComboSexo();   // Preenche o ComboBox de sexo
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxIdPet = new javax.swing.JTextField();
        jtxNome = new javax.swing.JTextField();
        jtxEspecie = new javax.swing.JTextField();
        jcbSexo = new javax.swing.JComboBox<>();
        jtxRaca = new javax.swing.JTextField();
        jtxPeso = new javax.swing.JTextField();
        jtxObservacoes = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPets = new javax.swing.JTable();
        jtxDataNascimento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbDono = new javax.swing.JComboBox<>();

        jLabel1.setText("Codigo");

        jLabel2.setText("nome");

        jLabel3.setText("especie");

        jLabel4.setText("Sexo");

        jLabel5.setText("Raça");

        jLabel6.setText("Data de nascimento");

        jLabel7.setText("Peso (kg)");

        jLabel8.setText("observações");

        jtxIdPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxIdPetActionPerformed(evt);
            }
        });

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtxPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxPesoActionPerformed(evt);
            }
        });

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jtPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "nome", "especie", "Sexo", "Raça", "Nascimento", "Peso", "Observações", "Dono"
            }
        ));
        jtPets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPetsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtPets);

        jLabel9.setText("Dono");

        jcbDono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxIdPet))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxEspecie)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbPesquisar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jcbDono, 0, 106, Short.MAX_VALUE)
                                                .addComponent(jtxDataNascimento))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(32, 32, 32)
                                        .addComponent(jtxPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jtxObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 208, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxIdPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtxRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jtxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jtxDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbSalvar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxIdPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxIdPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxIdPetActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        limparCampos();
        jtxIdPet.setEditable(false); // Código é auto-incremento
        jtxNome.setEditable(true);
        jtxEspecie.setEditable(true);
        jtxRaca.setEditable(true);
        jcbSexo.setEnabled(true);
        jtxDataNascimento.setEditable(true);
        jtxPeso.setEditable(true);
        jtxObservacoes.setEditable(true);
        jcbDono.setEnabled(true);
        
        jbPesquisar.setEnabled(false);
        jbNovo.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbSalvar.setEnabled(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    
    
    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        if (jtxIdPet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um Pet para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int idPet = Integer.parseInt(jtxIdPet.getText());
            String nome = jtxNome.getText();
            String especie = jtxEspecie.getText();
            String raca = jtxRaca.getText();
            String sexo = (String) jcbSexo.getSelectedItem();
            String dataNascimento = jtxDataNascimento.getText();
            // Validar e converter peso
            Float peso = Float.parseFloat(jtxPeso.getText());
            String observacoes = jtxObservacoes.getText();
            
            // Obter o ID do Dono selecionado no ComboBox (String)
            String nomeDonoSelecionado = (String) jcbDono.getSelectedItem();
            int donoId = 0; // Valor padrão
            // Percorre a lista de DonosModel para encontrar o ID correspondente ao nome
            // Se "Selecione um Dono" estiver selecionado, donoId permanece 0
            if (nomeDonoSelecionado != null && listaDonos != null && !nomeDonoSelecionado.equals("Selecione um Dono")) {
                for (DonosModel d : listaDonos) {
                    if (d.getNome().equals(nomeDonoSelecionado)) {
                        donoId = d.getDonoId(); // Obtém o ID do dono selecionado
                        break;
                    }
                }
            }
            
            // Validações básicas (verificar se o ID do Dono foi encontrado e outros campos)
            if (nome.isEmpty() || especie.isEmpty() || raca.isEmpty() || sexo == null || sexo.equals("Selecione o Sexo") || dataNascimento.isEmpty() || jtxPeso.getText().isEmpty() || donoId == 0) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios e selecione um Dono/Sexo válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            PetsModel pet = new PetsModel();
            pet.setIdPet(idPet);
            pet.setNome(nome);
            pet.setEspecie(especie);
            pet.setRaca(raca);
            pet.setSexo(sexo);
            pet.setDataNascimento(dataNascimento);
            pet.setPeso(peso);
            pet.setObservacoes(observacoes);
            pet.setDono_id(donoId); // Define o ID do dono no PetsModel
            
            PetsController controller = new PetsController();
            if (controller.editar(pet)) {
                JOptionPane.showMessageDialog(this, "Pet atualizado com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar Pet!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Peso inválido ou Código do Pet inválido. Digite apenas números!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (jtxIdPet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um Pet para excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este Pet?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        
        try {
            int idPet = Integer.parseInt(jtxIdPet.getText());
            PetsModel pet = new PetsModel();
            pet.setIdPet(idPet);
            
            PetsController controller = new PetsController();
            if (controller.excluir(pet)) {
                JOptionPane.showMessageDialog(this, "Pet excluído com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir Pet!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código do Pet inválido. Digite apenas números!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        if (jtxIdPet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o código do Pet para pesquisar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int idPet = Integer.parseInt(jtxIdPet.getText());
            PetsModel pet = new PetsModel();
            pet.setIdPet(idPet);
            
            PetsController controller = new PetsController();
            PetsModel petEncontrado = controller.selecionar(pet);
            
            if (petEncontrado != null) {
                jtxNome.setText(petEncontrado.getNome());
                jtxEspecie.setText(petEncontrado.getEspecie());
                jcbSexo.setSelectedItem(petEncontrado.getSexo());
                jtxRaca.setText(petEncontrado.getRaca());
                jtxDataNascimento.setText(petEncontrado.getDataNascimento());
                jtxPeso.setText(String.valueOf(petEncontrado.getPeso()));
                jtxObservacoes.setText(petEncontrado.getObservacoes()); // Preenche observações
                
                // Selecionar o dono correto no ComboBox (baseado no dono_id)
                int donoIdEncontrado = petEncontrado.getDonoId();
                if (donoIdEncontrado != 0 && listaDonos != null) {
                    for (int i = 0; i < listaDonos.size(); i++) {
                        if (listaDonos.get(i).getDonoId() == donoIdEncontrado) {
                            jcbDono.setSelectedIndex(i + 1); // +1 por causa do item "Selecione um Dono"
                            break;
                        }
                    }
                } else {
                    jcbDono.setSelectedIndex(0); // Nenhum dono selecionado, volta para "Selecione um Dono"
                }
                
                jtxIdPet.setEditable(false);
                jtxNome.setEditable(true);
                jtxEspecie.setEditable(true);
                jtxRaca.setEditable(true);
                jcbSexo.setEnabled(true);
                jtxDataNascimento.setEditable(true);
                jtxPeso.setEditable(true);
                jtxObservacoes.setEditable(true);
                jcbDono.setEnabled(true);
                
                jbNovo.setEnabled(false);
                jbSalvar.setEnabled(false);
                jbEditar.setEnabled(true);
                jbExcluir.setEnabled(true);
                
            } else {
                JOptionPane.showMessageDialog(this, "Pet não encontrado!", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                inicializar();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código do Pet inválido. Digite apenas números!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jtxPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxPesoActionPerformed

    private void jcbDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDonoActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        String nome = jtxNome.getText();
        String especie = jtxEspecie.getText();
        String raca = jtxRaca.getText();
        String sexo = (String) jcbSexo.getSelectedItem();
        String dataNascimento = jtxDataNascimento.getText();
        String observacoes = jtxObservacoes.getText();
        
        // Obter o ID do Dono selecionado no ComboBox (String)
        String nomeDonoSelecionado = (String) jcbDono.getSelectedItem();
        int donoId = 0; // Valor padrão para quando "Selecione um Dono" estiver selecionado
        if (nomeDonoSelecionado != null && listaDonos != null && !nomeDonoSelecionado.equals("Selecione um Dono")) {
            // Percorre a lista de DonosModel para encontrar o ID correspondente ao nome
            for (DonosModel d : listaDonos) {
                if (d.getNome().equals(nomeDonoSelecionado)) {
                    donoId = d.getDonoId(); // Obtém o ID do dono selecionado
                    break;
                }
            }
        }
        
        // Validações básicas (verificar se o ID do Dono foi encontrado e outros campos)
        if (nome.isEmpty() || especie.isEmpty() || raca.isEmpty() || sexo == null || sexo.equals("Selecione o Sexo") || dataNascimento.isEmpty() || jtxPeso.getText().isEmpty() || donoId == 0) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios e selecione um Dono/Sexo válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Float peso = Float.parseFloat(jtxPeso.getText());
            
            PetsModel pet = new PetsModel();
            pet.setNome(nome);
            pet.setEspecie(especie);
            pet.setRaca(raca);
            pet.setSexo(sexo);
            pet.setDataNascimento(dataNascimento);
            pet.setPeso(peso);
            pet.setObservacoes(observacoes);
            pet.setDono_id(donoId); // Define o ID do dono no PetsModel
            
            PetsController controller = new PetsController();
            if (controller.inserir(pet)) {
                JOptionPane.showMessageDialog(this, "Pet inserido com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir Pet!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Peso inválido. Digite apenas números!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtPetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPetsMouseClicked
        linha = jtPets.getSelectedRow();
        if (linha != -1) {
            jtxIdPet.setText(jtPets.getValueAt(linha, 0).toString());
            jtxNome.setText(jtPets.getValueAt(linha, 1).toString());
            jtxEspecie.setText(jtPets.getValueAt(linha, 2).toString());
           
            jcbSexo.setSelectedItem(jtPets.getValueAt(linha, 3).toString());
            
            jtxRaca.setText(jtPets.getValueAt(linha, 4).toString());
            jtxDataNascimento.setText(jtPets.getValueAt(linha, 5).toString());
            jtxPeso.setText(jtPets.getValueAt(linha, 6).toString());
            

            jtxObservacoes.setText(""); 

            
            String nomeDonoTabela = jtPets.getValueAt(linha, 8).toString(); 
            jtxObservacoes.setText(jtPets.getValueAt(linha, 7).toString());

            if (listaDonos != null) {
                
                for (int i = 0; i < listaDonos.size(); i++) {
                    if (listaDonos.get(i).getNome().equals(nomeDonoTabela)) {
                        jcbDono.setSelectedIndex(i + 1); 
                        break;
                    }
                }
            } else {
                jcbDono.setSelectedIndex(0); 
            }
            
            jtxIdPet.setEditable(false);
            jtxNome.setEditable(true);
            jtxEspecie.setEditable(true);
            jtxRaca.setEditable(true);
            jcbSexo.setEnabled(true);
            jtxDataNascimento.setEditable(true);
            jtxPeso.setEditable(true);
            jtxObservacoes.setEditable(true); 
            jcbDono.setEnabled(true);
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_jtPetsMouseClicked

    private void inicializar(){ // Renomeado de inicializa para padronização
        jtxIdPet.setEditable(true); // Editável para pesquisa
        jtxNome.setEditable(false);
        jtxEspecie.setEditable(false);
        jtxRaca.setEditable(false);
        jcbSexo.setEnabled(false);
        jtxDataNascimento.setEditable(false);
        jtxPeso.setEditable(false);
        jtxObservacoes.setEditable(false);
        jcbDono.setEnabled(false); // Desabilitado no início
        
        jbSalvar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbPesquisar.setEnabled(true);
        jbNovo.setEnabled(true);
        limparCampos();
    }
    
    private void limparCampos(){
       jtxIdPet.setText("");
       jtxNome.setText("");
       jtxEspecie.setText("");
       jtxRaca.setText("");
       jcbSexo.setSelectedIndex(0); // Volta para "Selecione o Sexo"
       jtxDataNascimento.setText("");
       jtxPeso.setText("");
       jtxObservacoes.setText("");
       jcbDono.setSelectedIndex(0); // Volta para "Selecione um Dono"
    }
    
    // Método para preencher o JComboBox de Donos
    private void preencherComboDonos(){ // Renomeado de preencherCombo
        DonosController controller = new DonosController();
        listaDonos = controller.selecionarTodos(); // Carrega a lista de donos
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Selecione um Dono"); // Item padrão/placeholder no índice 0
        
        if (listaDonos != null) { 
            for(DonosModel d: listaDonos){
                model.addElement(d.getNome()); // Adiciona o nome do dono
            }
        }
        jcbDono.setModel(model);
    }
    
    // Método para preencher o JComboBox de Sexo
    private void preencherComboSexo(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Selecione o Sexo"); // Item padrão/placeholder no índice 0
        model.addElement("Masculino");
        model.addElement("Feminino");
        jcbSexo.setModel(model);
    }
    
    // Método para preencher a tabela de Pets
    private void preencherTabela(){ // Renomeado de preencheTabela para padronização
        PetsController controller = new PetsController();
        ArrayList<PetsModel> lista = controller.selecionarTodos();
        DefaultTableModel modeloTabela = (DefaultTableModel) jtPets.getModel();
        modeloTabela.setRowCount(0); // Limpa a tabela
        
        // As colunas da JTable devem ser: "Codigo", "Nome", "Espécie", "Sexo", "Raça", "Nascimento", "Peso", "Dono"
        // (8 colunas no total, de índice 0 a 7)
        
        if(lista.isEmpty()){
            // Opcional: JOptionPane.showMessageDialog(this, "Nenhum Pet Encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
           // É vital que listaDonos esteja carregada antes de preencher a tabela para buscar os nomes.
           // Se preencherComboDonos() for chamado antes de preencherTabela(), listaDonos estará disponível.
           // Se não, você precisaria carregar listaDonos aqui também.
           // Para garantir, vamos recarregar listaDonos ou verificar se já está carregada.
           if (listaDonos == null || listaDonos.isEmpty()) {
               DonosController donosController = new DonosController();
               listaDonos = donosController.selecionarTodos();
           }

            for(PetsModel p: lista){
                String nomeDono = "N/A"; // Valor padrão se o dono não for encontrado
                if (listaDonos != null) {
                    for (DonosModel d : listaDonos) {
                        if (d.getDonoId() == p.getDonoId()) { // Pega o ID do dono do pet (dono_id)
                            nomeDono = d.getNome(); // Pega o nome do dono da listaDonos
                            break;
                        }
                    }
                }
                
                modeloTabela.addRow(new Object[]{
                    String.valueOf(p.getPetId()),
                    p.getNome(),
                    p.getEspecie(),
                    p.getSexo(),
                    p.getRaca(),
                    p.getDataNascimento(),
                    String.valueOf(p.getPeso()),
                    p.getObservacoes(),
                    nomeDono // Exibe o nome do Dono (coluna de índice 7)
                });
            }
        }   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbDono;
    private javax.swing.JComboBox<String> jcbSexo;
    private javax.swing.JTable jtPets;
    private javax.swing.JTextField jtxDataNascimento;
    private javax.swing.JTextField jtxEspecie;
    private javax.swing.JTextField jtxIdPet;
    private javax.swing.JTextField jtxNome;
    private javax.swing.JTextField jtxObservacoes;
    private javax.swing.JTextField jtxPeso;
    private javax.swing.JTextField jtxRaca;
    // End of variables declaration//GEN-END:variables
}