package kr.co.sist.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.sist.dao.EmpDAO;
import kr.co.sist.domain.EmpDomain;

/**
 * 업무 로직 처리
 * @author user
 *
 */
public class AjaxService {

	public String empJsonObj(int deptno) {
		
		//조회 결과를 사용하여 JSONObject으로 생성
		JSONObject jsonObj = new JSONObject();
		
		EmpDAO eDAO = new EmpDAO();
		try {
			List<EmpDomain> list = eDAO.selectDeptEmp(deptno);
			jsonObj.put("resultFlag", true);
			jsonObj.put("dataSize", list.size());
			
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonTemp = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for( EmpDomain ed : list ) {
				//조회 결과로 JSONObject을 생성
				jsonTemp = new JSONObject();
				jsonTemp.put("empno", ed.getEmpno());
				jsonTemp.put("ename", ed.getEname());
				jsonTemp.put("job", ed.getJob());
				jsonTemp.put("mgr", ed.getMgr());
				jsonTemp.put("hiredate", sdf.format(ed.getHiredate()));
				jsonTemp.put("sal", ed.getSal());
				jsonTemp.put("comm", ed.getComm());
				//부서번호는 접속자 화면에 남아있다.
				jsonArr.add(jsonTemp);
			}
			//JSONArray를 JSONObject에 할당
			jsonObj.put("data", jsonArr);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return jsonObj.toJSONString();
	}
	
}//class
