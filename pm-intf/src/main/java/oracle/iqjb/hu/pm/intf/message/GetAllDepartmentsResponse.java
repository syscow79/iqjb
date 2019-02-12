/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.intf.message;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oracle
 */
public class GetAllDepartmentsResponse extends ResponseBase {

    private List<DepartmentDto> departmentList;

    public GetAllDepartmentsResponse() {
        departmentList = new ArrayList<>();
    }

    public List<DepartmentDto> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<DepartmentDto> departmentList) {
        this.departmentList = departmentList;
    }

}
