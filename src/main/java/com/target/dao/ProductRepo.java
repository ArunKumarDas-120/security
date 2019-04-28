package com.target.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.target.dto.ProductDto;
import com.target.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity> {

	default List<ProductEntity> searchProduct(final ProductDto productDto) {

		return findAll(new Specification<ProductEntity>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				Predicate productPredicate = null;
				if (Objects.nonNull(productDto)) {
					SetJoin<Object, Object> companyJoin = root.joinSet("company", JoinType.INNER);
					SetJoin<Object, Object> categoryJoin = root.joinSet("catogery", JoinType.INNER);
					productPredicate = criteriaBuilder.disjunction();
					if (Objects.nonNull(productDto.getProductName())
							&& StringUtils.isNotBlank(productDto.getProductName()))
						productPredicate.getExpressions()
								.add(criteriaBuilder.like(root.get("productName"), productDto.getProductName() + "%"));
					if (Objects.nonNull(productDto.getProductModelNumber())
							&& StringUtils.isNotBlank(productDto.getProductModelNumber()))
						productPredicate.getExpressions().add(criteriaBuilder.like(root.get("productModelNumber"),
								productDto.getProductModelNumber() + "%"));
					if (Objects.nonNull(productDto.getProductSerialNumber())
							&& StringUtils.isNotBlank(productDto.getProductSerialNumber()))
						productPredicate.getExpressions().add(criteriaBuilder.like(root.get("productSerialNumber"),
								productDto.getProductSerialNumber() + "%"));
					if (Objects.nonNull(productDto.getCompany())
							&& StringUtils.isNotBlank(productDto.getCompany().getCompanyName()))
						productPredicate.getExpressions().add(criteriaBuilder.equal(companyJoin.get("companyName"),
								productDto.getCompany().getCompanyName()));
					if (Objects.nonNull(productDto.getCatogery())
							&& StringUtils.isNotBlank(productDto.getCatogery().getCatagoryName()))
						productPredicate.getExpressions().add(criteriaBuilder.equal(categoryJoin.get("catagoryName"),
								productDto.getCatogery().getCatagoryName()));

				}

				return productPredicate;
			}
		});
	}
}
