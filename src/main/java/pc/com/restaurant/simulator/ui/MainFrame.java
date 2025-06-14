/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pc.com.restaurant.simulator.ui;

import cardapio.Bebida;
import cardapio.ItemCardapio;
import cardapio.Lanche;
import cliente.Pessoa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import pc.com.restaurant.simulator.estabelecimento.Estabelecimento;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pc.com.restaurant.simulator.estabelecimento.ItemPedido;
import pc.com.restaurant.simulator.estabelecimento.Pedido;
import pc.com.restaurant.simulator.estabelecimento.StatusPedido;
/**
 *
 * @author pablo
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    private Estabelecimento estabelecimentoLoggado;
    private Pessoa cliente;
    
    private ArrayList<ItemPedido> itensPedidos = new ArrayList<>();
    
    /**
     * Creates new form MainFrame
     * @param estabelecimento
     * @param cliente
     */
    public MainFrame(Estabelecimento estabelecimento, Pessoa cliente) {
        this.estabelecimentoLoggado = estabelecimento;
        this.cliente = cliente;
        initComponents();
        
        // set de estados
        this.nomeCliente.setText(this.cliente.getNome());
        this.nomeEstabelecimento.setText(this.estabelecimentoLoggado.getNome());
        
        ArrayList<ItemCardapio> cardapio = new ArrayList<>(this.estabelecimentoLoggado.getCardapio());
        
        
        this.itensDoCardapio.addItem("-- Lanches --");
        for (ItemCardapio item : cardapio) {
            if (item instanceof Lanche) {
                this.itensDoCardapio.addItem(item.getNome());
            }
        }

        this.itensDoCardapio.addItem("-- Bebidas --");
        for (ItemCardapio item : cardapio) {
            if (item instanceof Bebida) {
                this.itensDoCardapio.addItem(item.getNome());
            }
        }
        
        this.itensDoCardapio.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                String item = value.toString();
                if (item.startsWith("--")) {
                    label.setFont(label.getFont().deriveFont(Font.BOLD));
                    label.setForeground(Color.WHITE);
                    label.setBackground(Color.BLACK);
                    
                } else {
                    label.setEnabled(true);
                }

                return label;
            }
        });
    }
    
    private void atualizarTabelaPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>(estabelecimentoLoggado.getPedidos());
        
        String[] colunas = {"Pedido N°", "Cliente", "Status", "Horário do Pedido", "Total"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (Pedido pedido : pedidos) {
            Object[] linha = new Object[5];
            linha[0] = pedido.getId();
            linha[1] = pedido.getCliente().getNome();
            linha[2] = pedido.getStatus().toString();
            linha[3] = pedido.getHoraPedido().format(formatter);
            linha[4] = String.format("R$ %.2f", pedido.calcularTotal());
            
            model.addRow(linha);
        }

        tabelaDePedidos.setModel(model);
    }

    public Estabelecimento getEstabelecimentoLoggado() {
        return estabelecimentoLoggado;
    }

    public void setEstabelecimentoLoggado(Estabelecimento estabelecimentoLoggado) {
        this.estabelecimentoLoggado = estabelecimentoLoggado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MainFrame other = (MainFrame) obj;
        return Objects.equals(this.cliente, other.cliente);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        itensDoCardapio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cadastrarItem = new javax.swing.JButton();
        nomeCliente = new javax.swing.JLabel();
        itemQuantidade = new javax.swing.JSpinner();
        CadastrarPedido = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaItemPedido = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        nomeEstabelecimento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDePedidos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaResumoDoPedido = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        finalizePedido = new javax.swing.JButton();
        deletePedido = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        totalPedido = new javax.swing.JLabel();
        prontoBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 720));

        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Cliente:");

        itensDoCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itensDoCardapioActionPerformed(evt);
            }
        });

        jLabel3.setText("Item cardapio:");

        jLabel4.setText("Quantidade:");

        cadastrarItem.setText("Cadastrar Item");
        cadastrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarItemActionPerformed(evt);
            }
        });

        nomeCliente.setToolTipText("");

        CadastrarPedido.setText("Cadastrar Pedido");
        CadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarPedidoActionPerformed(evt);
            }
        });

        jButton1.setText("remover item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listaItemPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaItemPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaItemPedido);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Estabelecimento:");

        tabelaDePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pedido N°", "Cliente", "Status", "Horário do Pedido", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaDePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDePedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaDePedidos);

        listaResumoDoPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaResumoDoPedidoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaResumoDoPedido);

        jLabel2.setText("Resumo do Pedido");

        finalizePedido.setText("Finalizar Pedido");
        finalizePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizePedidoActionPerformed(evt);
            }
        });

        deletePedido.setText("Remover Pedido");
        deletePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePedidoActionPerformed(evt);
            }
        });

        jLabel6.setText("Total do Pedido:");

        totalPedido.setText("R$ 0,00");

        prontoBotao.setText("Pedido Pronto");
        prontoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prontoBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadastrarPedido))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(itensDoCardapio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(cadastrarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemQuantidade)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(119, 119, 119)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeEstabelecimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(deletePedido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prontoBotao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(finalizePedido))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(62, 62, 62))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(nomeEstabelecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itensDoCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cadastrarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(finalizePedido)
                            .addComponent(deletePedido)
                            .addComponent(prontoBotao))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(totalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(CadastrarPedido)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(210, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private double calculaTotalItensPedidos(ArrayList<ItemPedido> itens) {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.getItemCardapio().getPreco() * item.getQuantidade();
        }

        return total;
    }
    
    private void cadastrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarItemActionPerformed
        String nomeSelecionado = (String) itensDoCardapio.getSelectedItem();

        if (nomeSelecionado == null || nomeSelecionado.startsWith("--")) {
            JOptionPane.showMessageDialog(null, "Selecione um item válido.");
            return;
        }
        
        int indexDoItemSelecionado = this.itensDoCardapio.getSelectedIndex();
        String nomeItemSelecionado = this.itensDoCardapio.getItemAt(indexDoItemSelecionado);
        
        ItemCardapio itemCardapioSelecionado = this.estabelecimentoLoggado.getItemCardapioFromCardapio(nomeItemSelecionado);
        int quantidadeDeItens = (int) itemQuantidade.getValue();
        
        boolean encontrado = false;

        for (ItemPedido ip : itensPedidos) {
            if (ip.getItemCardapio().getNome().equals(itemCardapioSelecionado.getNome())) {
                if (quantidadeDeItens == 0) {
                    itensPedidos.remove(ip);
                    double total = calculaTotalItensPedidos(itensPedidos);
                    totalPedido.setText(String.format("Total: R$ %.2f", total));
                } else {
                    ip.setQuantidade(quantidadeDeItens);
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado && quantidadeDeItens > 0) {
            ItemPedido itemPedidoCriado = new ItemPedido(itemCardapioSelecionado, quantidadeDeItens);
            this.itensPedidos.add(itemPedidoCriado);
        }
        
        this.listaItemPedido.removeAll();
        
        DefaultListModel<ItemPedido> listaDePedidos = new DefaultListModel<>();
        
        for (ItemPedido IP : itensPedidos) {
            listaDePedidos.addElement(IP);
        }
        
        this.listaItemPedido.setModel(listaDePedidos);
        
        double total = calculaTotalItensPedidos(itensPedidos);
        totalPedido.setText(String.format("R$ %.2f", total));
    }//GEN-LAST:event_cadastrarItemActionPerformed

    public void atualizarLista() {
        this.listaItemPedido.removeAll();
        
        DefaultListModel<ItemPedido> listaDePedidos = new DefaultListModel<>();
        
        for (ItemPedido IP : itensPedidos) {
            listaDePedidos.addElement(IP);
        }
        
        this.listaItemPedido.setModel(listaDePedidos);
    }
    
    private void itensDoCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itensDoCardapioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itensDoCardapioActionPerformed

    private void CadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarPedidoActionPerformed
        if (itensPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O pedido está vazio. Adicione itens antes de cadastrar.");
            return;
        }

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado.");
            return;
        }

        estabelecimentoLoggado.gerarPedido(cliente, itensPedidos);
        for (Pedido p : estabelecimentoLoggado.getPedidos()) {
            System.out.println(p.getItens());
        }
        atualizarTabelaPedidos();
        itensPedidos.clear();
        atualizarLista();
        totalPedido.setText(String.format("R$ %.2f", 0.0));
    }//GEN-LAST:event_CadastrarPedidoActionPerformed

    private int indexListaPedidoClicado; 
    private void listaItemPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaItemPedidoMouseClicked
        this.indexListaPedidoClicado = listaItemPedido.locationToIndex(evt.getPoint());
    }//GEN-LAST:event_listaItemPedidoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (indexListaPedidoClicado >= 0 && indexListaPedidoClicado < itensPedidos.size()) {
            itensPedidos.remove(indexListaPedidoClicado); // Remove da lista de dados
            atualizarLista(); // Atualiza o model da JList
            indexListaPedidoClicado = -1; // Reset para evitar erros futuros
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado para remover.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaResumoDoPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaResumoDoPedidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaResumoDoPedidoMouseClicked

    private void deletePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePedidoActionPerformed
        boolean removido = estabelecimentoLoggado.removerPedidoById(indexPedidoSelecionado);

        if (removido) {
            atualizarTabelaPedidos();
            limparResumoPedido();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido selecionado ou pedido não encontrado.");
        }
    }//GEN-LAST:event_deletePedidoActionPerformed

    private void mostrarItensDoPedido(Pedido pedido) {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Pedido ID: ").append(pedido.getId()).append("\n");
        resumo.append("Cliente: ").append(pedido.getCliente().getNome()).append("\n");
        resumo.append("Itens:\n");

        for (ItemPedido item : pedido.getItens()) {
            resumo.append("- ").append(item.getItemCardapio().getNome())
                  .append(" x").append(item.getQuantidade()).append("\n");
        }
        
        DefaultListModel<ItemPedido> model = new DefaultListModel<>();
        for (ItemPedido item : pedido.getItens()) {
            model.addElement(item);
        }
        
        listaResumoDoPedido.setModel(model);
    }
    
    private void limparResumoPedido() {
        DefaultListModel<ItemPedido> model = new DefaultListModel<>();
        listaResumoDoPedido.setModel(model);
    }
    
    private int indexPedidoSelecionado;
    private void tabelaDePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDePedidosMouseClicked
        int row = tabelaDePedidos.getSelectedRow();

        if (row != -1) {
            Object valorId = tabelaDePedidos.getValueAt(row, 0);
            if (valorId != null) {
                try {
                    
                    int idPedidoSelecionado = Integer.parseInt(valorId.toString());

                    indexPedidoSelecionado = idPedidoSelecionado;
                            
                    Pedido pedidoSelecionado = null;
                    
                    pedidoSelecionado = estabelecimentoLoggado.getPedidoById(idPedidoSelecionado);

                    if (pedidoSelecionado != null) {
                        mostrarItensDoPedido(pedidoSelecionado);
                    } else {
                        JOptionPane.showMessageDialog(this, "Pedido não encontrado.");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID inválido.");
                }
            }
        }
    }//GEN-LAST:event_tabelaDePedidosMouseClicked

    private void finalizePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizePedidoActionPerformed
        Pedido pedidoSelecionado = estabelecimentoLoggado.getPedidoById(indexPedidoSelecionado);

        if (pedidoSelecionado != null) {
            pedidoSelecionado.setStatus(StatusPedido.entregue);

            atualizarTabelaPedidos();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido selecionado ou pedido não encontrado.");
        }
    }//GEN-LAST:event_finalizePedidoActionPerformed

    private void prontoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prontoBotaoActionPerformed
        Pedido pedidoSelecionado = estabelecimentoLoggado.getPedidoById(indexPedidoSelecionado);

        if (pedidoSelecionado != null) {
            pedidoSelecionado.setStatus(StatusPedido.pronto);

            atualizarTabelaPedidos();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum pedido selecionado ou pedido não encontrado.");
        }
    }//GEN-LAST:event_prontoBotaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarPedido;
    private javax.swing.JButton cadastrarItem;
    private javax.swing.JButton deletePedido;
    private javax.swing.JButton finalizePedido;
    private javax.swing.JSpinner itemQuantidade;
    private javax.swing.JComboBox<String> itensDoCardapio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<ItemPedido> listaItemPedido;
    private javax.swing.JList<ItemPedido> listaResumoDoPedido;
    private javax.swing.JLabel nomeCliente;
    private javax.swing.JLabel nomeEstabelecimento;
    private javax.swing.JButton prontoBotao;
    private javax.swing.JTable tabelaDePedidos;
    private javax.swing.JLabel totalPedido;
    // End of variables declaration//GEN-END:variables
}
