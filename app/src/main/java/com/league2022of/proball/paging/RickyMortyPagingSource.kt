//package com.matchline2022.appwin.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.matchline2022.appwin.api.ApiService
//import com.matchline2022.appwin.model.Body
//
//class RickyMortyPagingSource
//    (
//    private val apiService: ApiService
//) : PagingSource<Int, Body>() {
//
//    override fun getRefreshKey(state: PagingState<Int, Body>): Int? {
//        return null
//    }
//
//    override suspend fun load(params: LoadParams<Int>):
//            LoadResult<Int, Body> {
//
//        return try {
//            val currentPage = params.key ?: 1
//            val response = apiService.getAllSport()
//            val responseData = mutableListOf<Body>()
//            val data = response.body()?.body ?: emptyList()
//            responseData.addAll(data)
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 1) null else -1,
//                nextKey = currentPage.plus(1)
//            )
//
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//}