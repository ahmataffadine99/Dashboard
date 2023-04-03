import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private base_url: string = "https://newsapi.org/v2/";
  private api_key: string = "a9f07a3a860845aaa62a647c47024826";
  private http_options: any = ({
    observe: 'response'
  });

  constructor(private http:HttpClient) { }

  async getHeadlines(country: any = 'in', category: string = null, sources: string = null, max: any = 6, page: any = null): Promise<any>{
    let url = this.base_url + 'top-headlines?country=' + country ;
    if(category){
      url += '&category=' + category;
    }
    if(sources){
      url += '&sources=' + sources;
    }
    if(page){
      url += '&page=' + page;
    }
    url += '&pageSize=' + max;
    url+= '&apiKey=' + this.api_key;
    return this.http.get(url, this.http_options).toPromise();
  }

}
