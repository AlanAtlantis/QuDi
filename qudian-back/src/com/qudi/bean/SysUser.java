package com.qudi.bean;

/**
 * ��̨��¼��Ϣ
 * 
 * @author AlanAtlantis
 *
 */
public class SysUser {

	private int id;
	private int usertype;// �û�����
	private String username;// �û���
	private String password;// ����
	private int level;// �ȼ�
	private int sex;// �Ա�
	private String phone;// �绰
	private String email;// ����
	private int notdel;//
	private String birthday;// ����
	private String address;// ��ַ
	private String remarks;// ��ע
	private int status;// ״̬
	private String createuser;// ������
	private String createdate;// ��������ʱ��
	private String updauser;// �޸Ĳ�����
	private String updadate;// �޸Ĳ���ʱ��

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SysUser[id=" + id + ",usertype=" + usertype + ",username=" + username + ",password=" + password
				+ ",level=" + level + ",sex=" + sex + ",phone=" + phone + ",email=" + email + ",notdel=" + notdel
				+ ",birthday=" + birthday + ",address=" + address + ",remarks=" + remarks + ",status=" + status
				+ ",createuser=" + createuser + ",createdate=" + createdate + ",updauser=" + updauser + ",updadate="
				+ updadate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNotdel() {
		return notdel;
	}

	public void setNotdel(int notdel) {
		this.notdel = notdel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdauser() {
		return updauser;
	}

	public void setUpdauser(String updauser) {
		this.updauser = updauser;
	}

	public String getUpdadate() {
		return updadate;
	}

	public void setUpdadate(String updadate) {
		this.updadate = updadate;
	}

}
