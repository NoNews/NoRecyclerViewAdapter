

# NoRecyclerViewAdapter
[ ![Download](https://api.bintray.com/packages/nonews/maven/norecyclerviewadapter/images/download.svg) ](https://bintray.com/nonews/maven/norecyclerviewadapter/_latestVersion)
[![API](https://img.shields.io/badge/API-15%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=null)

Simple base adapter for recyclerView with custom Freemarker templates.

### Gradle

Beginning with Gradle 3 `compile` is deprecated.

```
implementation 'ru.alexbykov:norecyclerviewadapter:0.0.1'
```

### Install
```java
 public class SampleRecyclerViewAdapter extends NoRecyclerViewAdapter<String, SampleRecyclerViewAdapter.ViewHolder> {
 
     private static final int LAYOUT = R.layout.item_sample;

     @Override
     public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         return new ViewHolder(inflate(parent, LAYOUT));
     }

     @Override
     public void onBindViewHolder(ViewHolder holder, int position) {
         holder.tvSample.setText(items.get(position));
     }

     public static class ViewHolder extends RecyclerView.ViewHolder {

         private TextView tvSample;

         public ViewHolder(View itemView) {
             super(itemView);
             tvSample = itemView.findViewById(R.id.tvSample);
         }

     }
 }
```

### Actions

```java
   adapter.add(item);
   adapter.add(item, position);
   adapter.remove(position);
   adapter.clear();
   adapter.addItems(items);
   adapter.getItem(position);
```


#### Roadmap

1.
2.
3.

#### Contributing

If you find any bug, or you have suggestions, don't be shy to create [issues](https://github.com/NoNews/NoRecyclerViewAdapter/issues) or make a [PRs](https://github.com/NoNews/NoRecyclerViewAdapter/pulls) in the `develop` branch.
You can read contribution guidelines [here](https://github.com/NoNews/NoRecyclerViewAdapter/blob/master/CONTRIBUTING.md)


#### My other libraries:
1. [NoPermission](https://github.com/NoNews/NoPermission) — Simple Android permission library, consist of only one class
2. [NoPaginate](https://github.com/NoNews/NoPaginate) — Simple Android pagination library

### License
```
Copyright 2018 Alex Bykov
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
