package com.target.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.target.dto.ProductDto;
import com.target.entity.CategoryEntity;
import com.target.entity.CompanyEntity;
import com.target.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity> {

	default List<ProductEntity> searchProduct(final ProductDto productDto) {

		return findAll(new Specification<ProductEntity>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if (Objects.nonNull(productDto.getCompany())
						&& Objects.nonNull(productDto.getCompany().getCompanyName())) {
					Join<ProductEntity, CompanyEntity> companyJoin = root.join("company");
					predicates.add(criteriaBuilder.equal(companyJoin.get("companyName"),
							productDto.getCompany().getCompanyName()));
				}
				if (Objects.nonNull(productDto.getCatogery())
						&& Objects.nonNull(productDto.getCatogery().getCatagoryName())
						&& !productDto.getCatogery().getCatagoryName().trim().isEmpty()) {
					Join<ProductEntity, CategoryEntity> typeJoin = root.join("catogery");
					predicates.add(criteriaBuilder.equal(typeJoin.get("catagoryName"),
							productDto.getCatogery().getCatagoryName()));
				}
				return criteriaBuilder.or(predicates.toArray(new Predicate[] {}));
			}
		});
	}
}
