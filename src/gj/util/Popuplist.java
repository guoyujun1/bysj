package gj.util;

import gj.service.PingYinUtil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * �ɼ����������б�
 */
public class Popuplist {

    /**
     * ���cbinput�ļ�ֵ
     * @param cbInput
     * @return
     */
    private boolean getAdjusting(JComboBox cbInput) {
        //�ж�cbipnut�ļ�ֵ�Ƿ�Ϊ����ֵ�����򷵻ؼ�ֵ�����򷵻�false
        if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
            return (Boolean) cbInput.getClientProperty("is_adjusting");
        }
        return false;
    }

    //����JComboBox�ļ�ֵ
    private void setAdjusting(JComboBox cbInput, boolean adjusting) {
        cbInput.putClientProperty("is_adjusting", adjusting);
    }

    public void setupAutoComplete(JTextField txtInput,ArrayList<String> items) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox cbInput = new JComboBox(model) {
            //����������߶�,������������߶�
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };
        //����cbinput�Ƿ�ɵ���
        setAdjusting(cbInput, false);
        for (String item : items) {
            model.addElement(item);
        }
        //���ó�ʼѡ��Ϊ��
        cbInput.setSelectedItem(null);
        cbInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!getAdjusting(cbInput)) {
                    if (cbInput.getSelectedItem() != null) {
                        txtInput.setText(cbInput.getSelectedItem().toString());
                    }
                }
            }
        });

        //��Ӽ��̼����¼�
        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                setAdjusting(cbInput, true);
                if (txtInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "����", "����Ϊ��", JOptionPane.PLAIN_MESSAGE);
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        if (cbInput.isPopupVisible()) {
                            e.setKeyCode(KeyEvent.VK_ENTER);
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_ENTER
                            || e.getKeyCode() == KeyEvent.VK_UP
                            || e.getKeyCode() == KeyEvent.VK_DOWN) {
                        e.setSource(cbInput);
                        cbInput.dispatchEvent(e);
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            txtInput.setText(cbInput.getSelectedItem().toString());
                            cbInput.setPopupVisible(false);
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        cbInput.setPopupVisible(false);
                    }
                    setAdjusting(cbInput, false);
                }
            }
        });

        //����������ݱ仯
        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            // ��textField��������ʱ����
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            // ��textField���ݱ�ɾ��ʱ����
            public void removeUpdate(DocumentEvent e) {
                updateList();
            }

            //��textField���ݷ����ı�ʱ����
            public void changedUpdate(DocumentEvent e) {
                updateList();
            }

            //ˢ��ѡ���б�
            private void updateList() {
                PingYinUtil pingYinUtil = new PingYinUtil();
                setAdjusting(cbInput, true);
                model.removeAllElements();
                String inputs = txtInput.getText();
                //�����ı���õ�������ת��Ϊƴ��
                String itemObjA = pingYinUtil.getPingYin(inputs.toString());
                String input = itemObjA.toString().toLowerCase();
                if (!inputs.isEmpty()) {
                    for (String item0 : items) {
                        //�������ݿ���ȡ��������ת��Ϊƴ��
                        String item1 = pingYinUtil.getPingYin(item0.toString());
                        //��������Ϣ�����ݿ���Ϣ���жԱȣ����ݿ�����ƴ��ͷ����������Ϣ��ͬ�����ݽ���ӵ��б���
                        if (item1.toLowerCase().startsWith(inputs.toLowerCase())) {
                            model.addElement(item0);
                        }
                    }
                }
                //���õ����Ŀɼ��ԣ���cbinput�����ѡ����������0�ǿɼ�
                cbInput.setPopupVisible(model.getSize() > 0);

                setAdjusting(cbInput, false);
            }
        });
        txtInput.setLayout(new BorderLayout());
        txtInput.add(cbInput, BorderLayout.SOUTH);
    }
}
