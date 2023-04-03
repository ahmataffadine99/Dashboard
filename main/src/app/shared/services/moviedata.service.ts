import { Injectable } from '@angular/core';
import {JsonpClientBackend, HttpClientJsonpModule} from '@angular/common/http';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs' //importo el Observable para tipar el método getPopularMovies()

@Injectable({
  providedIn: 'root'
})
export class MoviedataService {
  API_KEY: string;


  SEARCH_MOVIES: string;

 

  constructor(private http : HttpClient) { 


  }
  getNowPlayingMovies():Observable<any>{
    return this.http.get('https://api.themoviedb.org/3/movie/now_playing?api_key=9665330ff6117d22b62205893c303518');
  }
  getSearchMovies(term: string):Observable<any[]>{
    return this.http
    .get<[]>(`https://api.themoviedb.org/3/search/movie?api_key=9665330ff6117d22b62205893c303518&query=${term}`)
    //.map((data) => data['results']);


    //return this.http.get('${this.SEARCH_MOVIES}${searchStr}&sort_by=popularity.desc&api_key=${this.API_KEY}');
  }
}
