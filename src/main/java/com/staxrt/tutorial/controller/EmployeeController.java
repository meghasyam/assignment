/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.Output1Int;
import com.staxrt.tutorial.model.Output2Int;
import com.staxrt.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;


  @GetMapping("/count/{gender}")
  public ResponseEntity<List<Output2Int>> getCountByGender(@PathVariable(value = "gender") String gender)
      throws ResourceNotFoundException {
    List<Output2Int> list = employeeRepository.findCountByGender(gender);
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/minmax/{deptname}")
  public ResponseEntity<List<Output1Int>> getMinMaxByDept(@PathVariable(value = "deptname") String deptname)
          throws ResourceNotFoundException {
    List<Output1Int> list = employeeRepository.findMinMaxByDept(deptname);
    return ResponseEntity.ok().body(list);
  }

}
