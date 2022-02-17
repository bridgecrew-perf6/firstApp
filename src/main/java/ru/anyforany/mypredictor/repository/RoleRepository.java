package ru.anyforany.mypredictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anyforany.mypredictor.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
