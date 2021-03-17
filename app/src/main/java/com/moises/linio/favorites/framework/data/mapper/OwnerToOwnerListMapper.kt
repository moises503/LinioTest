package com.moises.linio.favorites.framework.data.mapper

import com.moises.linio.core.arch.Mapper
import com.moises.linio.favorites.domain.model.OwnerList
import com.moises.linio.favorites.framework.data.model.Owner

class OwnerToOwnerListMapper : Mapper<Owner, OwnerList>(){
    override fun transform(value: Owner): OwnerList {
        return OwnerList(
            id = value.linioId.orEmpty(),
            name = value.name.orEmpty(),
            email = value.email.orEmpty()
        )
    }
}