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


// 管理员管理信息界面类

@SuppressWarnings("serial")
public class AdminInformation extends JFrame {

    JFrame frame = new JFrame("湖南工程学院学生成绩管理系统");
    Container container = frame.getContentPane();

    //筛选按钮
    JButton buttonSelect, buttonUpdate, buttonAdd, buttonDelete,buttonOutput;
    //条件标签
    JLabel labelAcademy, labelMajor, labelClass, labelCourse, labelName, labelGrade,labelYear,labelSemester;
    //输入标签
    JComboBox comboBoxAcademy, comboBoxMajor, comboBoxCourse, comboBoxClass,comboBoxSYear,comboBoxSemester;
    //条件输入文本框
    JTextField  textFieldName, textFieldGrade;
    //表格
    JTable table;
    // 默认显示的表格
    DefaultTableModel tableModel;

    // 显示表格的滚动面板
    JScrollPane scrollPane;
    TeacherAction teacherAction = new TeacherAction();
    private String academy, major, clas, course, name;
    private float grade;
    private String[] columnNames = {"学号", "姓名", "专业", "课程", "平时成绩", "考试成绩", "总成绩","学期"};

    public AdminInformation() {

        container.setLayout(null);

        // 设置背景图片
//		new BackgroundImage(frame,container,"BookInformation.jpg");
        // 添加工具栏以及各组件和监听事件
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
        // 设置窗体表格
        setTable();

        // 事件处理
//		MyEvent();

        //将控件添加到窗体上
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
        // 设置窗口大小、位置、可视、默认关闭方式等
        new FrameOption(frame);
    }

    /**
     * 设置表格
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

            // 事件处理
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
     * 监听表格内容的改变
     */
//    private void MyEvent() {
//
//        tableModel.addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                System.out.println("表格已改变");
//            }
//        });
//    }

    //删除学生信息
    private void setButtonDelete() {
        buttonDelete.setText("删除");
        buttonDelete.setBounds(480, 300, 60, 25);
        // 删除
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                TeacherAction teacherAction = new TeacherAction();
                ExcelService excelService = new ExcelService();
                // 删除指定行
                int rowcount = table.getSelectedRow();
                String[][] value = excelService.setData(table,rowcount);
                teacherAction.deleteInformation(value);
                if (rowcount >= 0) {
                    tableModel.removeRow(rowcount);
                }
            }

        });
    }

    //增加学生信息
    private void setButtonAdd() {
        buttonAdd.setText("增加");
        buttonAdd.setBounds(400, 300, 60, 25);
        // 增加
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 增加一行空白区域
                tableModel.addRow(new Vector());
            }

        });
    }

    //学年
    private void setLabelYear() {
        labelYear.setText("学年");
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

    //学期
    private void setLabelSemester() {
        labelSemester.setText("学期");
        labelSemester.setBounds(310,10,30,25);
    }

    private void setComboBoxSemester() {
        comboBoxSemester.setBounds(350,10,80,25);
        String[] semester = new String[]{"第一期","第二期"};
        comboBoxSemester.addItem(semester[0]);
        comboBoxSemester.addItem(semester[1]);
        comboBoxSemester.setSelectedItem(null);
    }

    //姓名
    private void setLabelName() {
        // TODO Auto-generated method stub
        labelName.setText("姓名");
        labelName.setBounds(450, 10, 30, 25);
    }


    private void setFieldName() {
        // TODO Auto-generated method stub
        textFieldName.setBounds(480, 10, 80, 25);
    }

    //成绩
    private void setLabelGrade() {
        // TODO Auto-generated method stub
        labelGrade.setText("成绩低于");
        labelGrade.setBounds(490, 45, 55, 25);
    }

    private void setTextFieldGrade() {
        // TODO Auto-generated method stub
        textFieldGrade.setBounds(545, 45, 80, 25);
    }

    //课程
    private void setLabelCourse() {
        // TODO Auto-generated method stub
        labelCourse.setText("课程");
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
        // 添加条目选中状态改变的监听器
        comboBoxCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    course = String.valueOf(comboBoxCourse.getSelectedItem());
                }
            }
        });

    }

    //班级
    private void setLabelClass() {
        // TODO Auto-generated method stub
        labelClass.setText("班级");
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
        // 添加条目选中状态改变的监听器
        comboBoxClass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    clas = String.valueOf(comboBoxClass.getSelectedItem());
                }
            }
        });
    }

    //学院
    private void setLabelAcademy() {
        labelAcademy.setText("学院");
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
        // 添加条目选中状态改变的监听器
        comboBoxAcademy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    academy = String.valueOf(comboBoxAcademy.getSelectedItem());
                    //更新专业选择列表
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

    //专业
    private void setLabelMajor() {
        // TODO Auto-generated method stub
        labelMajor.setText("专业");
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
        // 添加条目选中状态改变的监听器
        comboBoxMajor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    major = String.valueOf(comboBoxMajor.getSelectedItem());
                    //更新课程选择列表
                    comboBoxCourse.removeAllItems();
                    List<String> list = teacherAction.SelectbyDB("course", major);
                    for (int i = 0; i < list.size(); ++i) {
                        comboBoxCourse.addItem(list.get(i));
                    }
                    comboBoxCourse.setSelectedItem(null);
                    //更新班级选择列表
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

    //检索按钮设置
    private void setButtonSelect() {
        // TODO Auto-generated method stub
        buttonSelect.setText("检索");
        buttonSelect.setBounds(670, 45, 80, 25);
        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                updateTable();
            }

        });
    }


    //同步到数据库按钮设置
    private void setButtonUpdate() {
        buttonUpdate.setText("同步数据");
        buttonUpdate.setBounds(560,300,90,25);
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherAction teacherAction = new TeacherAction();
                ExcelService excelService = new ExcelService();
                try {
                    String[][] value = excelService.setdata(table);
                    teacherAction.updateInformation(value);
                    JOptionPane.showMessageDialog(null, "成功", "更新成功"
                            , JOptionPane.PLAIN_MESSAGE);
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "错误", "更新失败"
                            , JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
    //导出表单按钮设置
    private void setButtonOutput() {
        // TODO Auto-generated method stub
        buttonOutput.setText("导出表单");
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
                    JOptionPane.showMessageDialog(null, "错误", "导出失败"
                            , JOptionPane.PLAIN_MESSAGE);
                }

            }
        });
    }

    /**
     * 刷新表格内容
     */
    private void updateTable(){
        //获取筛选条件
        String schoolyear = String.valueOf(comboBoxSYear.getSelectedItem());
        String semester = String.valueOf(comboBoxSemester.getSelectedItem());
        academy = String.valueOf(comboBoxAcademy.getSelectedItem());
        major = String.valueOf(comboBoxMajor.getSelectedItem());
        course = String.valueOf(comboBoxCourse.getSelectedItem());
        clas = String.valueOf(comboBoxClass.getSelectedItem());
        name = new String(textFieldName.getText());
        String[] str = new String[]{schoolyear,semester,academy,major,course,clas,name};
        //如果成绩栏没有输入，则设置为满分
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
            JOptionPane.showMessageDialog(null, "错误", "表格刷新失败"
                    , JOptionPane.PLAIN_MESSAGE);
        }
    }

}