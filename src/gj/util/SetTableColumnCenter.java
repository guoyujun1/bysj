package gj.util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * ���ñ�����ݶξ��У�����ͼ����Ϣ����ͽ��Ĺ�����
 * 
 */
public class SetTableColumnCenter {
	
	/**
	 * ������ݾ���
	 * @param table
	 */
	public SetTableColumnCenter(JTable table) {		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);   
		table.setDefaultRenderer(Object.class, r);	
	}
	
}
