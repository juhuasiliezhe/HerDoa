package tk.mybatis.springboot.model;

import java.util.List;

public class LayDates<T> {
		private Integer code;
		private String  msg;
		private long count;
		private List<T> data;
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public long getCount() {
			return count;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public List<T> getData() {
			return data;
		}
		public void setData(List<T> data) {
			this.data = data;
		}
		public LayDates(Integer code, String msg, long count, List<T> data) {
			super();
			this.code = code;
			this.msg = msg;
			this.count = count;
			this.data = data;
		}
		 
		 

}
