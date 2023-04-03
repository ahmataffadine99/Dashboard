import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class GithubService {
  username: string;
  repoName: string;
  clientId: string = "73d4af1e660bf3fcb3e4";
  clientSecret: string = "fd3bf4eb077d949f9047659d6bd3c9509f9310cb";
  apikey: string = 'ed13469f7ceba943c5a47d7211b725c1de07adba';

  constructor(private http: HttpClient) { }


  getUser() {
    return this.http.get("https://api.github.com/users/" + this.username + "?client_id=" + this.clientId + "&client_secret=" + this.clientSecret);
  }

  getUserRepos() {
    return this.http.get('https://api.github.com/users/' + this.username + '/repos'+ "?client_id=" + this.clientId + "&client_secret=" + this.clientSecret);
  }
  
  searchrepos() {
    return this.http.get('https://api.github.com/search/repositories?q=' + this.repoName, ({
      headers: new HttpHeaders({Authorization: `token ${this.apikey}`})
    }))
  }

  UpdateUser(username:string) {
    this.username = username;
  }

  UpdateRepo(repo:string) {
    this.repoName = repo;
  }

}
