package com.szy.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.szy.sqlite.model.Student;

/**
 * @author coolszy
 * @blog http://blog.csdn.net/coolszy
 */
public class StudentDAO2
{
	private DBOpenHelper helper;
	private SQLiteDatabase db;

	public StudentDAO2(Context context)
	{
		helper = new DBOpenHelper(context);
	}

	/**
	 * ����µ�ѧ����Ϣ
	 * 
	 * @param student
	 */
	public void add(Student student)
	{
		db = helper.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("sid", student.getSid());
		values.put("name", student.getName());
		values.put("age", student.getAge());
		//nullColumnHack����values����Ϊ�ջ�������û�����ݵ�ʱ������insert�ǻ�ʧ�ܵģ��ײ����ݿⲻ�������һ�����У���
		//Ϊ�˷�ֹ�������������Ҫ������ָ��һ����������ʱ��������ֽ�Ҫ�������Ϊ����ʱ���ͻὫ��ָ�������������ֵ��Ϊnull��
		//Ȼ���������ݿ��в��롣
		db.insert("t_student", "sid", values);
	}

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param student
	 */
	public void update(Student student)
	{
		db = helper.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("name", student.getName());
		values.put("age", student.getAge());
		db.update("t_student", values, "sid = ?", new String[]{String.valueOf(student.getSid())});
	}

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param sid
	 * @return
	 */
	public Student find(int sid)
	{
		db = helper.getWritableDatabase();
//		db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
		Cursor cursor = db.query("t_student", new String[]{"sid","name","age"}, "sid=?", new String[]{String.valueOf(sid)}, null, null, null);
		if (cursor.moveToNext())
		{
			return new Student(cursor.getInt(0), cursor.getString(1), cursor.getShort(2));
		}
		return null;
	}

	/**
	 * �h��ѧ����Ϣ
	 * 
	 * @param sids
	 */
	public void detele(Integer... sids)
	{
		if (sids.length > 0)
		{
			StringBuffer sb = new StringBuffer();
			String[] strPid=new String[sids.length];
			for (int i = 0; i < sids.length; i++)
			{
				sb.append('?').append(',');
				strPid[i]=String.valueOf(sids[i]);
			}
			sb.deleteCharAt(sb.length() - 1);
			db = helper.getWritableDatabase();
			db.delete("t_student", "sid in ("+sb+")", strPid);
		}
	}

	/**
	 * ��ȡѧ����Ϣ
	 * @param start ��ʵλ��
	 * @param count ѧ������
	 * @return
	 */
	public List<Student> getScrollData(int start, int count)
	{
		List<Student> students=new ArrayList<Student>();
		db = helper.getWritableDatabase();
		Cursor cursor=db.query("t_student", new String[]{"sid","name","age"}, null, null, null, null, "sid desc",start+","+count);
		while (cursor.moveToNext())
		{
			students.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getShort(2)));
		}
		return students;
	}

	/**
	 * ��ȡѧ������
	 * @return
	 */
	public long getCount()
	{
		db = helper.getWritableDatabase();
		Cursor cursor = db.query("t_student", new String[]{"count(*)"}, null, null, null, null, null);
		if (cursor.moveToNext())
		{
			return cursor.getLong(0);
		}
		return 0;
	}
}
