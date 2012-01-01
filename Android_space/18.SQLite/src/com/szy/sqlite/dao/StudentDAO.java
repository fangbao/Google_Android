package com.szy.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.szy.sqlite.model.Student;

/**
 * @author coolszy
 * @blog http://blog.csdn.net/coolszy
 */
public class StudentDAO
{
	private DBOpenHelper helper;
	private SQLiteDatabase db;

	public StudentDAO(Context context)
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
		db.execSQL("insert into t_student (sid,name,age) values (?,?,?)", new Object[]
		{ student.getSid(), student.getName(), student.getAge() });
	}

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param student
	 */
	public void update(Student student)
	{
		db = helper.getWritableDatabase();
		db.execSQL("update t_student set name = ?,age = ? where sid = ?", new Object[]
		{ student.getName(), student.getAge(), student.getSid() });
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
		Cursor cursor = db.rawQuery("select sid,name,age from t_student where sid = ?", new String[]
		{ String.valueOf(sid) });
		if (cursor.moveToNext())
		{
			return new Student(cursor.getInt(cursor.getColumnIndex("sid")), cursor.getString(cursor.getColumnIndex("name")), cursor.getShort(cursor.getColumnIndex("age")));
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
			for (int i = 0; i < sids.length; i++)
			{
				sb.append('?').append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
			SQLiteDatabase database = helper.getWritableDatabase();
			database.execSQL("delete from t_student where sid in (" + sb + ")", (Object[]) sids);
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
		List<Student> students = new ArrayList<Student>();
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from t_student limit ?,?", new String[]{ String.valueOf(start), String.valueOf(count) });
		while (cursor.moveToNext())
		{
			students.add(new Student(cursor.getInt(cursor.getColumnIndex("sid")), cursor.getString(cursor.getColumnIndex("name")), cursor.getShort(cursor.getColumnIndex("age"))));
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
		Cursor cursor = db.rawQuery("select count(sid) from t_student", null);
		if (cursor.moveToNext())
		{
			return cursor.getLong(0);
		}
		return 0;
	}
}
