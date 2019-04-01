package com.target.util;

import com.target.dto.RoleDto;
import com.target.dto.UserDto;
import com.target.entity.RoleEntity;
import com.target.entity.UserEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public final class BeanConverter {
	private final static MapperFacade mapper;

	static {
		final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(UserDto.class, UserEntity.class).byDefault().register();
		mapperFactory.classMap(RoleDto.class, RoleEntity.class).byDefault().register();
		mapper = mapperFactory.getMapperFacade();
	}

	public BeanConverter() {
	}

	public static <S, T> T mapObject(S source, Class<T> clazz) {
		return mapper.map(source, clazz);
	}
}
