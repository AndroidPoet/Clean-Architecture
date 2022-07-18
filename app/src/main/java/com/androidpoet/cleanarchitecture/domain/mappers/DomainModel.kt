package com.androidpoet.cleanarchitecture.domain.mappers


interface UiModelMapper<DomainModel , UiModel> {
    fun mapToPresentation(model: DomainModel): UiModel

    fun mapToDomain(modelItem: UiModel): DomainModel
}