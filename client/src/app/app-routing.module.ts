import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FindPaintPageComponent} from './components/find-paints/page/page.component';

const routes: Routes = [
  {path: '', component: FindPaintPageComponent},
  {
    path: 'find-paint',
    loadChildren: () => import('./components/find-paints/page/page.module')
      .then((m) => m.FindPaintPageModule)
  },
  {
    path: 'paint-management',
    loadChildren: () => import('./components/paint-management/page/page.module')
      .then((m) => m.PaintManagementModule)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
