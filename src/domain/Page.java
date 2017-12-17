package domain;

import java.util.List;

public class Page {
	private int totalrecord; //�ܼ�¼��
	private int pagesize = 3;    //ÿҳ��ʾ���ٸ�
	private int totalpage;    //��ҳ��
	
	private int pagenum;    //ÿ��ҳ
	private int startindex;  //����ҳ�ţ������ҳ�����ݿ��е���ʼλ��
	
	private int foreachbegin;  //����ҳ�ţ������ҳ����foreach��ǩ�Ŀ�ʼ��
	private int foreachend;    //����ҳ�ţ������ҳ����foreach��ǩ�Ľ�����
	
	private List list;    //��װҳ������
	
	
	public Page(int totalrecord,int pagenum){
		this.totalrecord = totalrecord;
		this.pagenum = pagenum;
		
		//�����ҳ��
		if(this.totalrecord%pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize + 1;
		}
		
		
		//����ҳ�ţ������ҳ������Ӧ�ô����ݿ��ĸ�λ�ÿ�ʼȡ
		this.startindex = (this.pagenum-1)*this.pagesize;
		
		//����ҳ�ţ����foreachbegin��foreachend
		if(this.totalpage<=10){
			this.foreachbegin = 1;
			this.foreachend = this.totalpage;
		}else{
			this.foreachbegin = this.pagenum-4;
			this.foreachend = this.pagenum+5;
			
			if(foreachbegin<1){
				this.foreachbegin = 1;
				this.foreachend = 10;
			}else if(this.foreachend>this.totalpage){
				this.foreachend = this.totalpage;
				this.foreachbegin = pagenum-10+1;
			}
		}
	}


	public int getTotalrecord() {
		return totalrecord;
	}


	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}


	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	public int getTotalpage() {
		return totalpage;
	}


	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}


	public int getPagenum() {
		return pagenum;
	}


	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}


	public int getStartindex() {
		return startindex;
	}


	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}


	public int getForeachbegin() {
		return foreachbegin;
	}


	public void setForeachbegin(int foreachbegin) {
		this.foreachbegin = foreachbegin;
	}


	public int getForeachend() {
		return foreachend;
	}


	public void setForeachend(int foreachend) {
		this.foreachend = foreachend;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}
}
