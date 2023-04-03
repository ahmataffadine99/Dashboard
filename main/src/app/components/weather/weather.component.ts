import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {SelectionComponent} from '../selection/selection.component';

export class Weather {
  city: String
  conditions: String
  temperature: number
  icon: String
  code: String
  humidity:number
  wind: number

  
}


@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent  {

  
 


  

}
