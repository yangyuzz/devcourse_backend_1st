package com.grepp.todo.model.dto

import com.grepp.todo.model.entity.TodoEntity

data class TodoDTO(
    var id:Int,
    var title:String,
    var done:Boolean,
) {
    // entity는 디비에 넣는 todo니까 사용자 누구인지 기록해야 됐었음.
    // dto는 현재 로그인한 사용자가 자기 todo 목록 보는건데 굳이 거기에 username을 기록할 필요가 있음?
    fun toEntity():TodoEntity{
        return TodoEntity(id=id, title=title,done=done)
    }
}