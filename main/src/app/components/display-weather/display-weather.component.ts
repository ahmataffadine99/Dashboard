import { Component, OnInit } from '@angular/core';
import { Weather } from '../../components/weather/weather.component';
import {DashboardComponent} from '../../components/dashboard/dashboard.component';


@Component({
  selector: 'app-display-weather',
  templateUrl: './display-weather.component.html',
  styleUrls: ['./display-weather.component.css']
})
export class DisplayWeatherComponent  {
  public unique_key: number;
  public parentRef: DashboardComponent;


  weather: Weather = {
    city: "No City",
    conditions: "-",
    temperature: 0,
    icon: "",
    code:"",
    humidity: 0,
    wind:0,

  }
  constructor() {
  }

 


   update(weather: Weather) {
    this.weather = weather
  }


}
