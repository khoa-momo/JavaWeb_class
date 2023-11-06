/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 *
 * @author DELL
 */
@Builder
@Getter
@Setter
@ToString
public class Student {
    private int sid;
    private String sname;
    private LocalDate dob;
    private int gender;
    private Department department;
}
