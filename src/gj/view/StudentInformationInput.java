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
    private final JFrame frame = new JFrame("��Excel���� ");
    private final Container container = frame.getContentPane();
    private JLabel labelSemester,labelPost,labelFilePath,labelFileaName;
    private JComboBox comboBoxPost, comboBoxSemester;
    private JTextField textFieldFilePath,textFieldFileName;


    // ���ð�ť
    private JButton buttonReset = new JButton();
    // ��¼��ť
    private JButton buttonConfirm = new JButton();

    private int id;

    public StudentInformationInput() {

        container.setLayout(null);

        //ѧ��ѡ�������ѡ���ֻ���ڵ���ɼ���ʱ�Ż���ʾ
        labelSemester = new JLabel();
        comboBoxSemester = new JComboBox();
        //����ѡ���ѡ�����
        labelPost = new JLabel();
        String[] listData = new String[]{"ѧ����", "��ʦ��", "רҵ��", "�γ̱�", "�ɼ���","ѧԺ��"};
        comboBoxPost = new JComboBox<String>(listData);
        //�����ļ��ļ�·��
        labelFilePath = new JLabel();
        textFieldFilePath = new JTextField();
        //�����ļ��ļ���
        labelFileaName = new JLabel();
        textFieldFileName = new JTextField();

        // ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
        setFrameOption();
        //����ѧ��ѡ����Լ������¼�
        setLabelSemester();
        setComboBoxSemester();
        // ����ѡ������Լ������¼�
        setLabelPost();
        setComboBoxPost();
        // �����ļ�·�����Լ������¼�
        setLabelFilePath();
        setTextFieldFilePath();
        // �����ļ������Լ������¼�
        setLabelFileName();
        setTextFieldFileName();
        //���õ�¼��ť�����ð�ť�¼�
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

    // ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
    private void setFrameOption() {
        // TODO Auto-generated method stub
        frame.setVisible(true);
        // ���ڲ��ɵ�����С
        frame.setResizable(false);
        frame.setSize(450, 360);
        frame.setLocation(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //����ѧ��ѡ��򼰱�ǩ
    private void setLabelSemester(){
        labelSemester.setText("ѡ��ѧ��");
        labelSemester.setBounds(80,25,180,25);
        //���ñ�ǩ���ɼ�
        labelSemester.setVisible(false);
    }

    private void setComboBoxSemester() {
        comboBoxSemester.setBounds(135,25,180,25);
        TeacherAction teacherAction = new TeacherAction();
        List<String> list = teacherAction.SelectbyDB("time", null);
        for (int i = 0; i < list.size(); ++i) {
            comboBoxSemester.addItem(list.get(i)+"��һ��");
            comboBoxSemester.addItem(list.get(i)+"�ڶ���");
        }
        //���ó�ʼĬ��ѡ��Ϊ��
        comboBoxSemester.setSelectedItem(null);
        //����ѡ��򲻿ɼ�
        comboBoxSemester.setVisible(false);
    }

    //���ñ�ѡ����ǩ
    private void setLabelPost() {
        labelPost.setText("��ѡ��Ҫ����ı�");
        labelPost.setBounds(30,60,180,30);
    }

    //���ñ�ѡ���
    private void setComboBoxPost() {
        comboBoxPost.setBounds(135,60,180,30);
        // �����Ŀѡ��״̬�ı�ļ�����
        comboBoxPost.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // ֻ����ѡ�е�״̬
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   String post = String.valueOf(comboBoxPost.getSelectedItem());
                   //��ѡ�гɼ���ʱ����ѧ��ѡ���ɼ�
                   if(post.equals("�ɼ���")){
                       labelSemester.setVisible(true);
                       comboBoxSemester.setVisible(true);
                   }

                }
            }
        });
    }

    //�����ļ�·����ǩ
    private void setLabelFilePath() {
        // TODO Auto-generated method stub
        labelFilePath.setText("�ļ�·��:");
        labelFilePath.setBounds(80, 110, 180, 30);
    }

    //�����ļ�·����
    private void setTextFieldFilePath() {
        // TODO Auto-generated method stub
        textFieldFilePath.setText("F:\\Excel\\");
        textFieldFilePath.setBounds(135, 110, 180, 30);
        // �����¼���������»س�����ת�������ļ���
        new KeyListener(textFieldFilePath, textFieldFileName);
    }

    //�����ļ�����ǩ
    private void setLabelFileName() {
        // TODO Auto-generated method stub
        labelFileaName.setText("�ļ���:");
        labelFileaName.setBounds(80, 160, 180, 30);
    }

    //�����ļ�����
    private void setTextFieldFileName() {
        // TODO Auto-generated method stub
        textFieldFileName.setBounds(135, 160, 180, 30);
        // �����¼���������»س���ģ����������ť
        new KeyListener(textFieldFileName, buttonConfirm);
    }

    //�������ð�ť��������¼�
    private void setButtonReset() {
        // TODO Auto-generated method stub
        buttonReset.setText("����");
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

    //���õ��밴ť��������¼�
    private void setButtonConfirm() {
        // TODO Auto-generated method stub
        buttonConfirm.setText("����");
        buttonConfirm.setBounds(110, 220, 90, 30);
        buttonConfirm.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent paramActionEvent) {
                // TODO Auto-generated method stub
                String filepath = new String(textFieldFilePath.getText());
                String filename = new String(textFieldFileName.getText());
                try {
                    if (filepath.equals("") || filename.equals("")) {
                        JOptionPane.showMessageDialog(null, "�ļ�·�����ļ�������Ϊ��", "����ʧ��", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        new InputExcel(id,filepath,filename);
                        JOptionPane.showMessageDialog(null, "�ļ�����ɹ�" , "�����ɹ�", JOptionPane.PLAIN_MESSAGE);
                        frame.setVisible(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}