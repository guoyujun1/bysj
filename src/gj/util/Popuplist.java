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
 * 可检索的下拉列表
 */
public class Popuplist {

    /**
     * 获得cbinput的键值
     * @param cbInput
     * @return
     */
    private boolean getAdjusting(JComboBox cbInput) {
        //判断cbipnut的键值是否为布尔值，是则返回键值，否则返回false
        if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
            return (Boolean) cbInput.getClientProperty("is_adjusting");
        }
        return false;
    }

    //设置JComboBox的键值
    private void setAdjusting(JComboBox cbInput, boolean adjusting) {
        cbInput.putClientProperty("is_adjusting", adjusting);
    }

    public void setupAutoComplete(JTextField txtInput,ArrayList<String> items) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox cbInput = new JComboBox(model) {
            //根据子组件高度,来调整父组件高度
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };
        //设置cbinput是否可调整
        setAdjusting(cbInput, false);
        for (String item : items) {
            model.addElement(item);
        }
        //设置初始选项为空
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

        //添加键盘监听事件
        txtInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                setAdjusting(cbInput, true);
                if (txtInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "错误", "输入为空", JOptionPane.PLAIN_MESSAGE);
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

        //监听表格内容变化
        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            // 当textField内容增加时触发
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            // 当textField内容被删减时触发
            public void removeUpdate(DocumentEvent e) {
                updateList();
            }

            //当textField内容发生改变时触发
            public void changedUpdate(DocumentEvent e) {
                updateList();
            }

            //刷新选择列表
            private void updateList() {
                PingYinUtil pingYinUtil = new PingYinUtil();
                setAdjusting(cbInput, true);
                model.removeAllElements();
                String inputs = txtInput.getText();
                //将从文本框得到的文字转换为拼音
                String itemObjA = pingYinUtil.getPingYin(inputs.toString());
                String input = itemObjA.toString().toLowerCase();
                if (!inputs.isEmpty()) {
                    for (String item0 : items) {
                        //将从数据库中取出的文字转换为拼音
                        String item1 = pingYinUtil.getPingYin(item0.toString());
                        //将输入信息与数据库信息进行对比，数据库数据拼音头部与输入信息相同的数据将添加到列表中
                        if (item1.toLowerCase().startsWith(inputs.toLowerCase())) {
                            model.addElement(item0);
                        }
                    }
                }
                //设置弹窗的可见性，当cbinput里的子选项数量大于0是可见
                cbInput.setPopupVisible(model.getSize() > 0);

                setAdjusting(cbInput, false);
            }
        });
        txtInput.setLayout(new BorderLayout());
        txtInput.add(cbInput, BorderLayout.SOUTH);
    }
}
