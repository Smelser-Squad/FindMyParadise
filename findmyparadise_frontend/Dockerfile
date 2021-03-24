FROM node:lts-alpine AS development

RUN mkdir /frontend
WORKDIR /frontend
COPY . .

RUN npm install -g @vue/cli
RUN npm install
ENV HOST=0.0.0.0
CMD [ "npm", "run", "serve" ]

FROM development AS build
RUN npm run build

FROM nginx:1.13-alpine

COPY --from=build /frontend/build /usr/share/nginx/html