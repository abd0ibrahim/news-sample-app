package com.rakshitjain.domain.usecases

import com.rakshitjain.domain.common.BaseFlowableUseCase
import com.rakshitjain.domain.common.FlowableRxTransformer
import com.rakshitjain.domain.entities.DataEntity
import com.rakshitjain.domain.entities.NewsSourcesEntity
import com.rakshitjain.domain.repositories.NewsDataStore
import com.rakshitjain.domain.repositories.NewsRepository
import io.reactivex.Flowable

class GetNewsUseCase(private val transformer: FlowableRxTransformer<NewsSourcesEntity>,
                     private val repositories: NewsRepository): BaseFlowableUseCase<NewsSourcesEntity>(transformer){

    companion object {
        private const val PARAM_FILE_NEWS_ENTITY = "param:NewsStatus"
    }

    override fun createFlowable(data: Map<String, Any>?): Flowable<NewsSourcesEntity> {
        return repositories.getNews()
    }

    fun getNews(): Flowable<NewsSourcesEntity>{
        val data = HashMap<String, String>()
        return single(data)
    }


}