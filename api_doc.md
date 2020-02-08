Playlist 생성 API

POST /user-playlist
   
Parameter
~~~  
Parameter	Type	Description

userId  	Long	(필수) 플레이 리스트 사용자 ID

locale  	title	(필수) 플레이 리스트 이름
~~~    
~~~  
Parameter Example

{
	"userId": 5,
	"title": "5's playlist"
}
~~~       
~~~  
Response Body
Http Status : 201 Created     

{
    "id": 4,
    "userId": 5,
    "title": "5's playlist",
    "userPlaylistSongs": []
}
~~~                    

Playlist 노래 추가 API

POST /user-playlist/{user-playlist-id}/user-playlist-song/song

Parameter                            
~~~                                      
Parameter	Type	Description      
                                     
Id	        Long	(필수) Song Id
~~~ 
Parameter Example 
~~~              
{
	"id": 1
}               
~~~   
Response Body

~~~           
Http Status : 201 Created       

{
    "id": 5,
    "userId": 5,
    "title": "5's playlist",
    "userPlaylistSongs": [
        {
            "id": 5,
            "song": {
                "title": "my album1 - 1",
                "id": 1,
                "track": 1,
                "length": 300
            }
        }
    ]
}

~~~
song 또는 user-playlist가 없는 경우
~~~
Http Status : 404 Not Found 

{
    "errorMsg": "resource is not exist"
}
~~~

Playlist 앨범 추가 API

POST /user-playlist/{user-playlist-id}/user-playlist-song/album

Parameter                            
~~~                                      
Parameter	Type	Description      
                                     
Id	        Long	(필수) album Id
~~~ 
Parameter Example 
~~~              
{
	"id": 1
}               
~~~  
Response Body

~~~           
Http Status : 201 Created  

{
    "id": 4,
    "userId": 6,
    "title": "6's playlist",
    "userPlaylistSongs": [
        {
            "id": 5,
            "song": {
                "title": "my album1 - 1",
                "id": 1,
                "track": 1,
                "length": 300
            }
        },
        {
            "id": 6,
            "song": {
                "title": "my album1 - 2",
                "id": 2,
                "track": 1,
                "length": 300
            }
        }
    ]
}
~~~

album 또는 user-playlist가 없는 경우
~~~
Http Status : 404 Not Found 

{
    "errorMsg": "resource is not exist"
}
~~~

Playlist 목록 API

GET /user/{user-id}/user-playlists

Parameter                            
~~~                                      
Parameter	Type	Description      
                                     
user-id	        Long	(필수) 사용자 id
~~~ 
Response Body

~~~           
Http Status : 200 OK

[
    {
        "id": 1,
        "userId": 1,
        "title": "user 1's playlist1",
        "userPlaylistSongs": [
            {
                "id": 1,
                "song": {
                    "title": "my album1 - 1",
                    "id": 1,
                    "track": 1,
                    "length": 300
                }
            },
            {
                "id": 2,
                "song": {
                    "title": "my album1 - 2",
                    "id": 2,
                    "track": 1,
                    "length": 300
                }
            }
        ]
    },
    {
        "id": 2,
        "userId": 1,
        "title": "user 1's playlist2",
        "userPlaylistSongs": [
            {
                "id": 3,
                "song": {
                    "title": "my album2 - 1",
                    "id": 3,
                    "track": 1,
                    "length": 300
                }
            }
        ]
    }
]

~~~

Playlist 삭제 API

DELETE /user-playlist/{user-playlist-id}

Parameter                            
~~~                                      
Parameter	        Type	Description      
                                     
user-playlist-id        Long	(필수) 사용자 id
~~~ 

Response Body

~~~           
Http Status : 200 OK
~~~