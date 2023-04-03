import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-json',
  templateUrl: './about-json.component.html',
  styleUrls: ['./about-json.component.css']
})
export class AboutJsonComponent implements OnInit {
  sample: any;


  constructor() { }

  ngOnInit() {
    this.sample= [{

        "client": {
            "host": "devapp"
        },
        "server": {
            "current_time": Date.now(),
            "services": [
                {
                    "name": "Weather",
                    "widgets": [
                        {
                            "name": "weather",
                            " description ": "Display temperature, conditions, humidity, wind speed for a city",
                            " params ": [
                                {
                                    "name": "city",
                                    "type ": "string"
                                }]
                        }]
                },
                {
                    " name ": "News",
                    " widgets ": [
                        {
                            " name ": "news",
                            " description ": "Top News in real time",
                            " params ": [
                                {
                                    " name ": "time",
                                    " type ": "integer"
                                }

                            ]
                        }
                    ]
                },
                {
                    " name ": "Youtube",
                    " widgets ": [
                        {
                            " name ": "youtube",
                            " description ": "Youtube search",
                            " params ": [
                                {
                                    " name ": "video",
                                    " type ": "string"
                                }

                            ]
                        }
                    ]
                },
                {
                    " name ": "Github User",
                    " widgets ": [
                        {
                            " name ": "github user",
                            " description ": "Github search user",
                            " params ": [
                                {
                                    " name ": "user",
                                    " type ": "string"
                                }

                            ]
                        }
                    ]
                },
            ]
        }

    }]
  }

}
