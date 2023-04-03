import { Component, OnInit } from '@angular/core';
import { Weather } from '../../components/weather/weather.component';


@Component({
  selector: 'app-weather-true',
  templateUrl: './weather-true.component.html',
  styleUrls: ['./weather-true.component.css']
})
export class WeatherTrueComponent implements OnInit {
  weather: Weather = {
    city: "No City",
    conditions: "-",
    temperature: 0,
    icon: "",
    code:"",
    humidity: 0,
    wind:0,

  }

  constructor() { }

  ngOnInit(): void {
  }

  update(weather: Weather) {
    this.weather = weather
  }

}
