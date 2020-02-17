package gj.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

//  �޶��ı�������������ַ���������

@SuppressWarnings("serial")
public class LimitTextLength extends PlainDocument {
	
	int maxLength;
	
	// �вι��죬����Ϊ�ı��������ַ���󳤶�
	public LimitTextLength(int newMaxLength) {
		super();
		 maxLength = newMaxLength; 		
	}

	/**
	 * ���ظ��෽��
	 */
	public void insertString(int offset,String str, AttributeSet a) throws BadLocationException{
		if (getLength() + str.length() > maxLength) {
			return;
		} else {
			super.insertString(offset, str, a);
		}
	}
	
	
	
}