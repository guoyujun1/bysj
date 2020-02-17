package gj.view;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import gj.controller.TeacherAction;
import gj.model.Student;
import gj.model.Teacher;
import gj.model.User;
import gj.service.ExcelService;
import gj.util.AdminMenuBar;
import gj.util.FrameOption;
import gj.util.KeyListener;


// ����Ա������Ϣ������

@SuppressWarnings("serial")
public class AdminInformation extends JFrame {

    JFrame frame = new JFrame("���Ϲ���ѧԺѧ���ɼ�����ϵͳ");
    Container container = frame.getContentPane();

    //ɸѡ��ť
    JButton buttonSelect, buttonUpdate, buttonAdd, buttonDelete,buttonOutput;
    //������ǩ
    JLabel labelAcademy, labelMajor, labelClass, labelCourse, labelName, labelGrade,labelYear,labelSemester;
    //�����ǩ
    JComboBox comboBoxAcademy, comboBoxMajor, comboBoxCourse, comboBoxClass,comboBoxSYear,comboBoxSemester;
    //���������ı���
    JTextField  textFieldName, textFieldGrade;
    //���
    JTable table;
    // Ĭ����ʾ�ı��
    DefaultTableModel tableModel;

    // ��ʾ���Ĺ������
    JScrollPane scrollPane;
    TeacherAction teacherAction = new TeacherAction();
    private String academy, major, clas, course, name;
    private float grade;
    private String[] columnNames = {"ѧ��", "����", "רҵ", "�γ�", "ƽʱ�ɼ�", "���Գɼ�", "�ܳɼ�","ѧ��"};

    public AdminInformation() {

        container.setLayout(null);

        // ���ñ���ͼƬ
//		new BackgroundImage(frame,container,"BookInformation.jpg");
        // ��ӹ������Լ�������ͼ����¼�
        new AdminMenuBar(frame);

        labelSemester = new JLabel();
        setLabelSemester();
        comboBoxSemester = new JComboBox();
        setComboBoxSemester();
        labelYear = new JLabel();
        setLabelYear();
        comboBoxSYear = new JComboBox();
        setComboBoxSYear();
        labelAcademy = new JLabel();
        setLabelAcademy();
        comboBoxAcademy = new JComboBox();
        setComboBoxAcademy();
        labelMajor = new JLabel();
        setLabelMajor();
        comboBoxMajor = new JComboBox();
        setComboBoxMajor();
        labelClass = new JLabel();
        setLabelClass();
        comboBoxClass = new JComboBox();
        setComboBoxClass();
        labelCourse = new JLabel();
        setLabelCourse();
        comboBoxCourse = new JComboBox();
        setComboBoxCourse();
        labelName = new JLabel();
        setLabelName();
        textFieldName = new JTextField();
        setFieldName();
        labelGrade = new JLabel();
        setLabelGrade();
        textFieldGrade = new JTextField();
        setTextFieldGrade();
        buttonSelect = new JButton();
        setButtonSelect();
        buttonUpdate = new JButton();
        setButtonUpdate();
        buttonAdd = new JButton();
        setButtonAdd();
        buttonDelete = new JButton();
        setButtonDelete();
        buttonOutput = new JButton();
        setButtonOutput();
        // ���ô�����
        setTable();

        // �¼�����
//		MyEvent();

        //���ؼ���ӵ�������
        container.add(scrollPane);

        container.add(labelYear);
        container.add(comboBoxSYear);
        container.add(labelSemester);
        container.add(comboBoxSemester);
        container.add(labelAcademy);
        container.add(comboBoxAcademy);
        container.add(labelMajor);
        container.add(comboBoxMajor);
        container.add(labelClass);
        container.add(comboBoxClass);
        container.add(labelCourse);
        container.add(comboBoxCourse);
        container.add(labelName);
        container.add(textFieldName);
        container.add(labelGrade);
        container.add(textFieldGrade);

        container.add(buttonSelect);
        container.add(buttonUpdate);
        container.add(buttonAdd);
        container.add(buttonDelete);
        container.add(buttonOutput);
        // ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
        new FrameOption(frame);
    }

    /**
     * ���ñ��
     */
    private void setTable() {
        try {
            TeacherAction teacherAction = new TeacherAction();
            Object[][] results = teacherAction.initializTable(columnNames);
            tableModel = new DefaultTableModel(results,columnNames);
            table = new JTable(tableModel);

            scrollPane = new JScrollPane(table);
            scrollPane.setViewportView(table);
            scrollPane.setBounds(20, 90, 760, 190);

            // �¼�����
//            MyEvent();
            TableEvent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void TableEvent(){
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent paramKeyEvent) {
                if(paramKeyEvent.getKeyChar()=='\n'){
                    int rowcount = table.getSelectedRow();
                    TeacherAction teacherAction = new TeacherAction();
                    ExcelService excelService = new ExcelService();
                    String[][] value = excelService.setData(table,rowcount);
                    teacherAction.updateInformation(value);
                }
            }
        });
    }

    /**
     * ����������ݵĸı�
     */
//    private void MyEvent() {
//
//        tableModel.addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                System.out.println("����Ѹı�");
//            }
//        });
//    }

    //ɾ��ѧ����Ϣ
    private void setButtonDelete() {
        buttonDelete.setText("ɾ��");
        buttonDelete.setBounds(480, 300, 60, 25);
        // ɾ��
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                TeacherAction teacherAction = new TeacherAction();
                ExcelService excelService = new ExcelService();
                // ɾ��ָ����
                int rowcount = table.getSelectedRow();
                String[][] value = excelService.setData(table,rowcount);
                teacherAction.deleteInformation(value);
                if (rowcount >= 0) {
                    tableModel.removeRow(rowcount);
                }
            }

        });
    }

    //����ѧ����Ϣ
    private void setButtonAdd() {
        buttonAdd.setText("����");
        buttonAdd.setBounds(400, 300, 60, 25);
        // ����
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ����һ�пհ�����
                tableModel.addRow(new Vector());
            }

        });
    }

    //ѧ��
    private void setLabelYear() {
        labelYear.setText("ѧ��");
        labelYear.setBounds(115,10,35,25);
    }

    private void setComboBoxSYear(){
        comboBoxSYear.setBounds(150,10,150,25);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("time", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxSYear.addItem(list.get(i));
        }
        comboBoxSYear.setSelectedItem(null);
    }

    //ѧ��
    private void setLabelSemester() {
        labelSemester.setText("ѧ��");
        labelSemester.setBounds(310,10,30,25);
    }

    private void setComboBoxSemester() {
        comboBoxSemester.setBounds(350,10,80,25);
        String[] semester = new String[]{"��һ��","�ڶ���"};
        comboBoxSemester.addItem(semester[0]);
        comboBoxSemester.addItem(semester[1]);
        comboBoxSemester.setSelectedItem(null);
    }

    //����
    private void setLabelName() {
        // TODO Auto-generated method stub
        labelName.setText("����");
        labelName.setBounds(450, 10, 30, 25);
    }


    private void setFieldName() {
        // TODO Auto-generated method stub
        textFieldName.setBounds(480, 10, 80, 25);
    }

    //�ɼ�
    private void setLabelGrade() {
        // TODO Auto-generated method stub
        labelGrade.setText("�ɼ�����");
        labelGrade.setBounds(490, 45, 55, 25);
    }

    private void setTextFieldGrade() {
        // TODO Auto-generated method stub
        textFieldGrade.setBounds(545, 45, 80, 25);
    }

    //�γ�
    private void setLabelCourse() {
        // TODO Auto-generated method stub
        labelCourse.setText("�γ�");
        labelCourse.setBounds(260, 45, 30, 25);
    }

    private void setComboBoxCourse() {
        // TODO Auto-generated method stub
        comboBoxCourse.setBounds(290, 45, 80, 25);
        comboBoxCourse.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("course", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxCourse.addItem(list.get(i));
        }
        comboBoxCourse.setSelectedItem(null);
        // �����Ŀѡ��״̬�ı�ļ�����
        comboBoxCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // ֻ����ѡ�е�״̬
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    course = String.valueOf(comboBoxCourse.getSelectedItem());
                }
            }
        });

    }

    //�༶
    private void setLabelClass() {
        // TODO Auto-generated method stub
        labelClass.setText("�༶");
        labelClass.setBounds(375, 45, 30, 25);
    }

    private void setComboBoxClass() {
        // TODO Auto-generated method stub
        comboBoxClass.setBounds(405, 45, 80, 25);
        comboBoxClass.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("class", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxClass.addItem(list.get(i));
        }
        comboBoxClass.setSelectedItem(null);
        // �����Ŀѡ��״̬�ı�ļ�����
        comboBoxClass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // ֻ����ѡ�е�״̬
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    clas = String.valueOf(comboBoxClass.getSelectedItem());
                }
            }
        });
    }

    //ѧԺ
    private void setLabelAcademy() {
        labelAcademy.setText("ѧԺ");
        labelAcademy.setBounds(20, 45, 30, 25);
    }

    private void setComboBoxAcademy() {
        comboBoxAcademy.setBounds(50, 45, 80, 25);
        comboBoxAcademy.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("academy", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxAcademy.addItem(list.get(i));
        }
        comboBoxAcademy.setSelectedItem(null);
        // �����Ŀѡ��״̬�ı�ļ�����
        comboBoxAcademy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // ֻ����ѡ�е�״̬
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    academy = String.valueOf(comboBoxAcademy.getSelectedItem());
                    //����רҵѡ���б�
                    comboBoxMajor.removeAllItems();
                    List<String> list = teacherAction.SelectbyDB("major", academy);
                    for (int i = 0; i < list.size(); ++i) {
                        comboBoxMajor.addItem(list.get(i));
                    }
                    comboBoxMajor.setSelectedItem(null);
                }
            }
        });
    }

    //רҵ
    private void setLabelMajor() {
        // TODO Auto-generated method stub
        labelMajor.setText("רҵ");
        labelMajor.setBounds(135, 45, 30, 25);
    }

    private void setComboBoxMajor() {
        // TODO Auto-generated method stub
        comboBoxMajor.setBounds(165, 45, 90, 25);
        comboBoxMajor.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("major", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxMajor.addItem(list.get(i));
        }
        comboBoxMajor.setSelectedItem(null);
        // �����Ŀѡ��״̬�ı�ļ�����
        comboBoxMajor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // ֻ����ѡ�е�״̬
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    major = String.valueOf(comboBoxMajor.getSelectedItem());
                    //���¿γ�ѡ���б�
                    comboBoxCourse.removeAllItems();
                    List<String> list = teacherAction.SelectbyDB("course", major);
                    for (int i = 0; i < list.size(); ++i) {
                        comboBoxCourse.addItem(list.get(i));
                    }
                    comboBoxCourse.setSelectedItem(null);
                    //���°༶ѡ���б�
                    comboBoxClass.removeAllItems();
                    List<String> lists = teacherAction.SelectbyDB("class", major);
                    for (int i = 0; i < lists.size(); ++i) {
                        comboBoxClass.addItem(lists.get(i));
                    }
                    comboBoxClass.setSelectedItem(null);
                }
            }
        });
    }

    //������ť����
    private void setButtonSelect() {
        // TODO Auto-generated method stub
        buttonSelect.setText("����");
        buttonSelect.setBounds(670, 45, 80, 25);
        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                updateTable();
            }

        });
    }


    //ͬ�������ݿⰴť����
    private void setButtonUpdate() {
        buttonUpdate.setText("ͬ������");
        buttonUpdate.setBounds(560,300,90,25);
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherAction teacherAction = new TeacherAction();
                ExcelService excelService = new ExcelService();
                try {
                    String[][] value = excelService.setdata(table);
                    teacherAction.updateInformation(value);
                    JOptionPane.showMessageDialog(null, "�ɹ�", "���³ɹ�"
                            , JOptionPane.PLAIN_MESSAGE);
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "����", "����ʧ��"
                            , JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
    //��������ť����
    private void setButtonOutput() {
        // TODO Auto-generated method stub
        buttonOutput.setText("������");
        buttonOutput.setBounds(670, 300, 90, 25);
        buttonOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                ExcelService excelService = new ExcelService();
                String[][] value = excelService.setdata(table);
                try {
                    new StudentInformationOutput(value);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "����", "����ʧ��"
                            , JOptionPane.PLAIN_MESSAGE);
                }

            }
        });
    }

    /**
     * ˢ�±������
     */
    private void updateTable(){
        //��ȡɸѡ����
        String schoolyear = String.valueOf(comboBoxSYear.getSelectedItem());
        String semester = String.valueOf(comboBoxSemester.getSelectedItem());
        academy = String.valueOf(comboBoxAcademy.getSelectedItem());
        major = String.valueOf(comboBoxMajor.getSelectedItem());
        course = String.valueOf(comboBoxCourse.getSelectedItem());
        clas = String.valueOf(comboBoxClass.getSelectedItem());
        name = new String(textFieldName.getText());
        String[] str = new String[]{schoolyear,semester,academy,major,course,clas,name};
        //����ɼ���û�����룬������Ϊ����
        if (textFieldGrade.getText().equals("")) {
            grade = 100;
        } else {
            grade = Float.parseFloat(textFieldGrade.getText());
        }
        try {
            Object[][] results = teacherAction.selectInformation(columnNames, str, grade);
            tableModel = new DefaultTableModel(results, columnNames);
            table.setModel(tableModel);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "����", "���ˢ��ʧ��"
                    , JOptionPane.PLAIN_MESSAGE);
        }
    }

}