package com.wsc.oa.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wsc.oa.identity.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> , JpaSpecificationExecutor<Role>{

}
