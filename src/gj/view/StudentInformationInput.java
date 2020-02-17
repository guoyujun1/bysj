package gj.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.*;

import gj.controller.InputExcel;
import gj.controller.TeacherAction;
import gj.util.KeyListener;

public class StudentInformationInput {
    private final JFrame frame = new JFrame("从Excel导入 ");
    private final Container container = frame.getContentPane();
    private JLabel labelSemester,labelPost,labelFilePath,labelFileaName;
    private JComboBox comboBoxPost, comboBoxSemester;
    private JTextField textFieldFilePath,textFieldFileName;


    // 重置按钮
    private JButton buttonReset = new JButton();
    // 登录按钮
    private JButton buttonConfirm = new JButton();

    private int id;

    public StudentInformationInput() {

        container.setLayout(null);

        //学期选择框，特殊选择框，只有在导入成绩表单时才会显示
        labelSemester = new JLabel();
        comboBoxSemester = new JComboBox();
        //设置选择框，选择导入表单
        labelPost = new JLabel();
        String[] listData = new String[]{"学生表", "教师表", "专业表", "课程表", "成绩表","学院表"};
        comboBoxPost = new JComboBox<String>(listData);
        //导出文件文件路径
        labelFilePath = new JLabel();
        textFieldFilePath = new JTextField();
        //导出文件文件名
        labelFileaName = new JLabel();
        textFieldFileName = new JTextField();

        // 设置窗口大小、位置、可视、默认关闭方式等
        setFrameOption();
        //设置学年选择框以及监听事件
        setLabelSemester();
        setComboBoxSemester();
        // 设置选择表单框以及监听事件
        setLabelPost();
        setComboBoxPost();
        // 设置文件路径框以及监听事件
        setLabelFilePath();
        setTextFieldFilePath();
        // 设置文件名框以及监听事件
        setLabelFileName();
        setTextFieldFileName();
        //设置登录按钮和重置按钮事件
        setButtonConfirm();
        setButtonReset();

        container.add(labelSemester);
        container.add(comboBoxSemester);
        container.add(labelPost);
        container.add(comboBoxPost);
        container.add(labelFilePath);
        container.add(textFieldFilePath);
        container.add(labelFileaName);
        container.add(textFieldFileName);
        container.add(buttonConfirm);
        container.add(buttonReset);
    }

    // 设置窗口大小、位置、可视、默认关闭方式等
    private void setFrameOption() {
        // TODO Auto-generated method stub
        frame.setVisible(true);
        // 窗口不可调整大小
        frame.setResizable(false);
        frame.setSize(450, 360);
        frame.setLocation(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //设置学年选择框及标签
    private void setLabelSemester(){
        labelSemester.setText("选择学期");
        labelSemester.setBounds(80,25,180,25);
        //设置标签不可见
        labelSemester.setVisible(false);
    }

    private void setComboBoxSemester() {
        comboBoxSemester.setBounds(135,25,180,25);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("time", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxSemester.addItem(list.get(i)+"第一期");
            comboBoxSemester.addItem(list.get(i)+"第二期");
        }
        //设置初始默认选项为空
        comboBoxSemester.setSelectedItem(null);
        //设置选择框不可见
        comboBoxSemester.setVisible(false);
    }

    //设置表单选择框标签
    private void setLabelPost() {
        labelPost.setText("请选择要导入的表");
        labelPost.setBounds(30,60,180,30);
    }

    //设置表单选择框
    private void setComboBoxPost() {
        comboBoxPost.setBounds(135,60,180,30);
        // 添加条目选中状态改变的监听器
        comboBoxPost.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   String post = String.valueOf(comboBoxPost.getSelectedItem());
                   //当选中成绩表时设置学期选择框可见
                   if(post.equals("成绩表")){
                       labelSemester.setVisible(true);
                       comboBoxSemester.setVisible(true);
                   }

                }
            }
        });
    }

    //设置文件路径标签
    private void setLabelFilePath() {
        // TODO Auto-generated method stub
        labelFilePath.setText("文件路径:");
        labelFilePath.setBounds(80, 110, 180, 30);
    }

    //设置文件路径框
    private void setTextFieldFilePath() {
        // TODO Auto-generated method stub
        textFieldFilePath.setText("F:\\Excel\\");
        textFieldFilePath.setBounds(135, 110, 180, 30);
        // 键盘事件，如果按下回车则跳转到输入文件名
        new KeyListener(textFieldFilePath, textFieldFileName);
    }

    //设置文件名标签
    private void setLabelFileName() {
        // TODO Auto-generated method stub
        labelFileaName.setText("文件名:");
        labelFileaName.setBounds(80, 160, 180, 30);
    }

    //设置文件名框
    private void setTextFieldFileName() {
        // TODO Auto-generated method stub
        textFieldFileName.setBounds(135, 160, 180, 30);
        // 键盘事件，如果按下回车则模拟点击导出按钮
        new KeyListener(textFieldFileName, buttonConfirm);
    }

    //设置重置按钮及其监听事件
    private void setButtonReset() {
        // TODO Auto-generated method stub
        buttonReset.setText("重置");
        buttonReset.setBounds(240, 220, 90, 30);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                textFieldFilePath.setText("F:\\Excel\\");
                textFieldFileName.setText("");
            }
        });
    }

    //设置导入按钮及其监听事件
    private void setButtonConfirm() {
        // TODO Auto-generated method stub
        buttonConfirm.setText("导入");
        buttonConfirm.setBounds(110, 220, 90, 30);
        buttonConfirm.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent paramActionEvent) {
                // TODO Auto-generated method stub
                String filepath = new String(textFieldFilePath.getText());
                String filename = new String(textFieldFileName.getText());
                try {
                    if (filepath.equals("") || filename.equals("")) {
                        JOptionPane.showMessageDialog(null, "文件路径和文件名不能为空", "导出失败", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        new InputExcel(id,filepath,filename);
                        JOptionPane.showMessageDialog(null, "文件导入成功" , "导出成功", JOptionPane.PLAIN_MESSAGE);
                        frame.setVisible(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}