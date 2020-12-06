package pack180801_jdbc;

public class JDBC08_Reflection {
/**
 * 1.������SQL��ѯ���õ������
 * 2.���÷��䴴��ʵ������󣺴���Person����
 * 3.��ȡ��������еı�����
 * 4.�ٻ�ȡ�������ÿһ�е�ֵ����ϵõ�һ��map�������еı�����ֵ���е�ֵ
 * 5.�����÷����Ӧ�����Ը�ֵ�����Լ�Ϊmap�ļ���ֵ��Ϊmap��ֵ
 * 
 * ResultSetMetaData��
 * 1.what��������ResultSet��Ԫ���ݶ��󡣼����п��Ի�ȡ��������ж����У�������ʲô
 * 2.how���õ�ResultSetMetaData���󣺵���ResultSet��getMetaData()����
 *       ResultSetMetaData�ķ�����
 *            int getColumnCount()��sql����а�����Щ��
 *            string getColumnLabel(int column)����ȡָ���еı�����������1��ʼ
 * */
	public static void main(String[] args) {
		String sql = "SELECT id,name,age,sex,birth FROM person "
				+ "WHERE id = ?";
		JDBC06_Person person = JDBC03_Tool.select(JDBC06_Person.class, sql, 3);
		System.out.println(person.toString());
		sql = "SELECT id,name,age,sex,birth FROM person "
				+ "WHERE name = ?";
		JDBC06_Person person2 = JDBC03_Tool.select(JDBC06_Person.class, sql, "wss");
		System.out.println(person2.toString());
	}
}
