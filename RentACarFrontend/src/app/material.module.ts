// material.module.ts
import { ModuleWithProviders, NgModule} from "@angular/core";
import { MatStepperModule } from '@angular/material/stepper';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatMenuModule } from '@angular/material/menu';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTreeModule } from '@angular/material/tree';

@NgModule({
    imports: [



    ],
    exports: [

    ],
    providers: [
    ]
})
export class MaterialModule {
    constructor() {
        // matIconRegistry.registerFontClassAlias('fontawesome', 'fa');
    }

    static forRoot(): ModuleWithProviders {
        return {
            ngModule: MaterialModule,

        };
    }
}
